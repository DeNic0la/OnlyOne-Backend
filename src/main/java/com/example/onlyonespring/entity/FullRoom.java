package com.example.onlyonespring.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "room")
public class FullRoom extends Room {

    @Getter
    @Setter
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "room_player",
            joinColumns = @JoinColumn(name = "player_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "room_id",
                    referencedColumnName = "id"))
    private List<Player> joinedPlayers;

    @Override
    public String toString() {
        return "FullRoom{" +
                "joinedPlayers=" + joinedPlayers +
                super.toString() +
                '}';
    }

    @Override
    public Integer getPlayer_count() {
        if (this.joinedPlayers == null || this.joinedPlayers.isEmpty()) {
            return 0;
        }
        return this.joinedPlayers.size(); /* Calls the Integer.valueOf(int) function*/

    }
}
