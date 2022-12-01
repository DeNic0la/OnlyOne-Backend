package com.example.onlyonespring.controller;

import com.example.onlyonespring.repository.PlayerRepository;
import com.example.onlyonespring.repository.RoomRepository;
import org.openapitools.model.Card;
import org.openapitools.model.GameStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {
    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/game/{id}")
    public ResponseEntity<GameStatus> getStatus(@RequestHeader("x-user") String userName, @PathVariable Long id) {
        var optional = playerRepository.findPlayerByUsername(userName);
        if (optional.isPresent()) {
            var user = optional.get();
            var optionalJoinedRoom = user.getJoinedRooms().stream().findFirst();
            if (optionalJoinedRoom.isPresent()) {
                var joinedRoom = optionalJoinedRoom.get();

                return ResponseEntity.ok(GameStatus.builder()
                        .topCard(Card.builder().number(joinedRoom.getTopCardNumber())
                                .color(joinedRoom.getTopCardColor())
                                .build())
                        .isYourTurn(joinedRoom.getCurrentPlayer().getId()
                                .equals(user.getId()))
                        .build());
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
