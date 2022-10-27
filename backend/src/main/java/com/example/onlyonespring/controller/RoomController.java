package com.example.onlyonespring.controller;

import com.example.onlyonespring.Exception.FourZeroFourException;
import com.example.onlyonespring.entity.FullRoom;
import com.example.onlyonespring.entity.Player;
import com.example.onlyonespring.entity.Room;
import com.example.onlyonespring.repository.PlayerRepository;
import com.example.onlyonespring.repository.RoomRepository;
import lombok.val;
import org.openapitools.api.RoomApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RoomController implements RoomApi {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private PlayerRepository playerRepository;


    @GetMapping("/room")
    public List<Room> getAllRooms() {
        return roomRepository.findAll().stream().map(Room::new).toList();

    }

    @PostMapping("/room")
    public Room createRoom(@RequestBody String roomName){
        val room = new FullRoom();
        room.setName(roomName);
        room.setPlayer_count(0);
        room.setMax_player_count(10);
        room.setStatus("lobby");
        Room savedRoom = new Room(roomRepository.saveAndFlush(room));
        return savedRoom;
    }

    @PostMapping("/room/{id}")
    public boolean joinRoom(@RequestHeader("x-user") String user,@PathVariable Integer id){
        Optional<FullRoom> byId = this.roomRepository.findById(id);
        byId.ifPresentOrElse(fullRoom -> {
            playerRepository.findPlayerByUsername(user).ifPresentOrElse(player -> {
                this.playerJoinRoom(player,fullRoom);
            },() -> {
                Player player = new Player();
                player.setUsername(user);
                Player savedPlayer = playerRepository.saveAndFlush(player);
                System.out.println(savedPlayer);
                this.playerJoinRoom(player,fullRoom);
            });
        }, () -> { throw new FourZeroFourException(); });
        return true;
    }

    private void playerJoinRoom(Player p,FullRoom r){
        List<FullRoom> joinedRooms = p.getJoinedRooms();
        if (joinedRooms == null) joinedRooms = new ArrayList<>();
        System.out.println(r);
        System.out.println(p);
        joinedRooms.add(r);
        p.setJoinedRooms(joinedRooms);
        playerRepository.save(p);
    }

    @GetMapping("/room/{id}")
    public Room getRoomInfo(@PathVariable Integer id){
        Optional<FullRoom> room = roomRepository.findById(id);
        if (room.isPresent()){
            return new Room(room.get());
        }
        throw new FourZeroFourException();

    }

    @PutMapping("/room/{id}")
    public ResponseEntity<String> leaveRoom(@RequestHeader("x-user") String user,@PathVariable Integer id){
        Optional<Player> playerByUsername = playerRepository.findPlayerByUsername(user);
        Optional<FullRoom> byId = roomRepository.findById(id);

        if (playerByUsername.isPresent() && byId.isPresent()){
            Player player = playerByUsername.get();
            FullRoom fullRoom = byId.get();
            List<Player> joinedPlayers = fullRoom.getJoinedPlayers();
            joinedPlayers.remove(player);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        throw new FourZeroFourException();
    }
}
