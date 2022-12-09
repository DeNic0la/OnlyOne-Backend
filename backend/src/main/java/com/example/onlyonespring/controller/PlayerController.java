package com.example.onlyonespring.controller;


import com.example.onlyonespring.entity.FullRoom;
import com.example.onlyonespring.repository.PlayerRepository;
import com.example.onlyonespring.repository.RoomRepository;
import org.openapitools.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
public class PlayerController {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @PostMapping("/play/{id}")
    public ResponseEntity<String> playCard(@RequestHeader("x-user") String username, @PathVariable Long id, @RequestBody Card card) {

        var optionalRoom = roomRepository.findById(id);
        var user = HelperController.getOrCreatePlayerByUsername(username, playerRepository);

        if (optionalRoom.isPresent()) {
            var room = optionalRoom.get();

            if (room.getCurrentPlayer().getUsername() == user.getUsername()) {
                var topCard = Card.builder().number(room.getTopCardNumber()).color(room.getTopCardColor()).build();
                if (Objects.isNull(card)) {
                    decideNextPlayer(room);
                    roomRepository.save(room);
                    return ResponseEntity.ok("no card played, next turn");
                } else if (cardCanBePlayed(card, topCard)) {
                    room.setTopCardNumber(card.getNumber());
                    room.setTopCardColor(card.getColor());
                    decideNextPlayer(room);
                    roomRepository.save(room);
                    return ResponseEntity.ok("card was played");
                } else {
                    return ResponseEntity.badRequest().body("card cannot be played");
                }
            } else {
                return ResponseEntity.badRequest().body("it's not your turn");
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private void decideNextPlayer(FullRoom room) {
        var joinedPlayers = room.getJoinedPlayers();
        var currentPlayerIndex = joinedPlayers.indexOf(room.getCurrentPlayer());
        int nextPlayerIndex = currentPlayerIndex == joinedPlayers.size() - 1 ? 0 : currentPlayerIndex + 1;
        room.setCurrentPlayer(joinedPlayers.get(nextPlayerIndex));
    }

    private boolean cardCanBePlayed(Card card, Card topCard) {
        return topCard == null || card.getColor().equals(topCard.getColor()) || card.getNumber().equals(topCard.getNumber());
    }
}
