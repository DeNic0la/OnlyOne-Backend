package com.example.onlyonespring.controller;

import com.example.onlyonespring.entity.Player;
import com.example.onlyonespring.repository.PlayerRepository;

import java.util.Optional;

public class HelperController {
    public static Player getOrCreatePlayerByUsername(String playerName, PlayerRepository repo){
        Optional<Player> playerByUsername = repo.findPlayerByUsername(playerName);
        if (playerByUsername.isPresent()) return playerByUsername.get();
        Player p = new Player();
        p.setUsername(playerName);
        return repo.saveAndFlush(p);
    }
}
