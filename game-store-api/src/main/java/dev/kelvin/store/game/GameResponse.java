package dev.kelvin.store.game;

import lombok.*;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameResponse {
    private String id;
    private String name;
    private Set<String> platforms;
    private String imgUrl;
}
