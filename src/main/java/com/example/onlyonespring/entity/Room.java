package com.example.onlyonespring.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Room {

    public Room(FullRoom r){
        this.id = r.getId();
        this.status = r.getStatus();
        this.name = r.getName();
        this.max_player_count = r.getMax_player_count();
        this.player_count = r.getPlayer_count();
    }

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Getter
    @Setter
    @Column(name = "name", nullable = false)
    private String name;

    @Getter
    @Setter
    private Integer player_count;

    @Getter
    @Setter
    @Column(name = "max_player_count", nullable = false)
    private Integer max_player_count;

    @Getter
    @Setter
    @Column(name = "status", nullable = false)
    private String status;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", player_count=" + player_count +
                ", max_player_count=" + max_player_count +
                ", status='" + status + '\'' +
                '}';
    }
}