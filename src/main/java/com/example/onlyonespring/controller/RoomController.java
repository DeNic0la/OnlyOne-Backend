package com.example.onlyonespring.controller;

import com.example.onlyonespring.entity.Room;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RoomController {


    @GetMapping("/room")
    public List<Room> getAllRooms(){
        ArrayList<Room> rooms = new ArrayList<>();
        Room room1 = this.getExampleRoom(1);
        Room room2 = this.getExampleRoom(2);
        Room room3 = this.getExampleRoom(3);

        room1.setStatus("lobby");
        room2.setStatus("run");
        room3.setStatus("finished");
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        return rooms;
    }

    private Room getExampleRoom(int random){
        val room = new Room();
        room.setName("Toms cool people club "+ random);
        room.setId(random);
        room.setPlayer_count(random);
        room.setMax_player_count(10);
        return room;
    }
}
