package com.example.onlyonespring.repository;

import com.example.onlyonespring.entity.FullRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<FullRoom, Integer> {
}