package com.example.onlyonespring.entity;

import lombok.Getter;
import lombok.Setter;
import org.openapitools.model.Card;
import org.openapitools.model.Room;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "room")
public class FullRoom {

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Getter
    @Setter
    private Long topCardNumber;
    @Getter
    @Setter
    private Card.ColorEnum topCardColor;

    @Getter
    @Setter
    @OneToOne
    private Player currentPlayer;

    @Getter
    @Setter
    @Column(name = "name", nullable = false)
    private String name;

    @Getter
    @Setter
    private Long player_count;

    @Getter
    @Setter
    @Column(name = "max_player_count", nullable = false)
    private Long max_player_count;

    @Getter
    @Setter
    @Column(name = "status", nullable = false)
    private Room.StatusEnum status;

    @Setter
    @Getter
    private String host;

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

    public Integer getPlayer_count() {
        if (this.joinedPlayers == null || this.joinedPlayers.isEmpty()) {
            return 0;
        }
        return this.joinedPlayers.size(); /* Calls the Integer.valueOf(int) function*/

    }
}
