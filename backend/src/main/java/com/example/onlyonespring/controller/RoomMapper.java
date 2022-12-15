package com.example.onlyonespring.controller;

import com.example.onlyonespring.entity.FullRoom;
import com.example.onlyonespring.entity.Player;
import org.openapitools.model.Room;
import org.springframework.stereotype.Service;

@Service
public class RoomMapper {
    public Room toDto(FullRoom entity) {
        Room room = new Room();
        room.setId(entity.getId());
        room.setStatus(entity.getStatus());
        room.setName(entity.getName());
        room.setMaxPlayerCount(entity.getMax_player_count());
        room.setPlayerCount(entity.getPlayer_count().longValue());

        if (room.getStatus() != Room.StatusEnum.FINISHED) {
            Player host = entity.getJoinedPlayers() == null ? null : entity.getJoinedPlayers().get(0);
            room.setHost((host == null ? "" : host.getUsername()));
        }
        return room;
    }
}
