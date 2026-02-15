package dev.kelvin.store.game;

import dev.kelvin.store.category.Category;
import dev.kelvin.store.platform.Platform;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class GameMapper {
    public Game toGame(GameRequest gameRequest) {
        return Game.builder().
                title(gameRequest.title())
                .category(Category.builder().id(gameRequest.categoryId()).build())
                .build();
    }

}
