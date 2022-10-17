package com.example.onlyonespring.controller;

import com.example.onlyonespring.entity.FullRoom;
import com.example.onlyonespring.entity.Room;
import com.example.onlyonespring.repository.RoomRepository;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/room")
    public List<Room> getAllRooms(){
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

}
