package com.example.onlyonespring.repository;

import com.example.onlyonespring.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    Optional<Player> findPlayerByUsername(String username);
}