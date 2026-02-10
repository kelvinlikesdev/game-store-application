package dev.kelvin.store.comment;

import dev.kelvin.store.common.BaseEntity;
import dev.kelvin.store.game.Game;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment extends BaseEntity {
    private String comments;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;
}
