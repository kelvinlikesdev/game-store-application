package dev.kelvin.store.game;

import dev.kelvin.store.platform.Console;
import org.springframework.data.jpa.domain.Specification;

public class GameSpecification {

    public static Specification<Game> byGameId(String gameId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), gameId);
    }

    public static Specification<Game> byGameTitle(String gameTitle) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("title"), gameTitle);
    }

    public static Specification<Game> bySupportedPlatforms(Console platform) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("platform"), platform);
    }
}
