package dev.kelvin.store.game;

import dev.kelvin.store.platform.Platform;

import java.util.Set;

public record GameRequest(
        String title, // perform a check to see if the title is unique
        String categoryId, //we need to that category exists
        Set<String> platforms // we need to that platforms exists

) {
}
