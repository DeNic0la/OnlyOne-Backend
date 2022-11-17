package com.example.onlyonespring.controller;

import com.example.onlyonespring.Exception.FourZeroFourException;
import com.example.onlyonespring.Exception.YouAreHackerException;
import com.example.onlyonespring.entity.FullRoom;
import com.example.onlyonespring.entity.Player;
import com.example.onlyonespring.repository.PlayerRepository;
import com.example.onlyonespring.repository.RoomRepository;
import org.openapitools.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private RoomMapper roomMapper;


    @GetMapping("/room")
    public ResponseEntity<List<Room>> findAll() {
        return ResponseEntity.ok(roomRepository.findAll().stream().map(roomMapper::toDto).toList());
    }

    @PostMapping("/room")
    public Room createRoom(@RequestBody String roomName) {
        var room = new FullRoom();
        room.setName(roomName);
        room.setPlayer_count(0L);
        room.setMax_player_count(10L);
        room.setStatus(Room.StatusEnum.LOBBY);
        roomRepository.saveAndFlush(room);
        return roomMapper.toDto(room);
    }

    @PostMapping("/room/{id}")
    public boolean joinRoom(@RequestHeader("x-user") String user, @PathVariable Long id) {
        Optional<FullRoom> byId = this.roomRepository.findById(id);
        byId.ifPresentOrElse(fullRoom -> {
            Player player = HelperController.getOrCreatePlayerByUsername(user, playerRepository);
            this.playerJoinRoom(player, fullRoom);
        }, () -> {
            throw new FourZeroFourException();
        });
        return true;
    }

    @PostMapping("/state/{id}")
    public boolean changeRoomState(@RequestHeader("x-user") String user, @PathVariable Long id, @RequestBody String state) {
        Optional<FullRoom> byId = this.roomRepository.findById(id);
        byId.ifPresentOrElse(fullRoom -> {
            Player player = HelperController.getOrCreatePlayerByUsername(user, playerRepository);
            Player host = null;
            try {
                host = fullRoom.getJoinedPlayers().get(0);
                host.getUsername();
            } catch (Exception e) {
                throw new YouAreHackerException();
            }
            if (Objects.equals(host.getUsername(), player.getUsername())) {
                if (Objects.equals(state, "run")) {
                    fullRoom.setStatus(Room.StatusEnum.RUN);
                } else if (Objects.equals(state, "finished")) {
                    fullRoom.setStatus(Room.StatusEnum.FINISHED);
                } else throw new YouAreHackerException();
                roomRepository.save(fullRoom);
            } else {
                throw new YouAreHackerException();
            }

        }, () -> {
            throw new FourZeroFourException();
        });
        return true;
    }

    private void playerJoinRoom(Player p, FullRoom r) {
        List<FullRoom> joinedRooms = p.getJoinedRooms();
        if (joinedRooms.contains(r)) {
            System.out.println(p.getUsername() + " Already Joined Room " + r.getId());
        } else {
            joinedRooms = Arrays.asList(r); //TODO: Change joinedRooms to joinedRoom
            p.setJoinedRooms(joinedRooms);
            playerRepository.save(p);
        }
    }

    @GetMapping("/room/{id}")
    public Room getRoomInfo(@PathVariable Long id) {
        Optional<FullRoom> room = roomRepository.findById(id);
        if (room.isPresent()) {
            return roomMapper.toDto(room.get());
        }
        throw new FourZeroFourException();

    }

    @PutMapping("/room/{id}")
    public ResponseEntity<String> leaveRoom(@RequestHeader("x-user") String user, @PathVariable Long id) {
        Optional<Player> playerByUsername = playerRepository.findPlayerByUsername(user);
        Optional<FullRoom> byId = roomRepository.findById(id);

        if (playerByUsername.isPresent() && byId.isPresent()) {
            Player player = playerByUsername.get();
            FullRoom fullRoom = byId.get();
            List<Player> joinedPlayers = fullRoom.getJoinedPlayers();
            joinedPlayers.remove(player);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        throw new FourZeroFourException();
    }
}
