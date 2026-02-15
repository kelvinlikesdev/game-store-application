package dev.kelvin.store.game;

import dev.kelvin.store.category.CategoryRepository;
import dev.kelvin.store.comment.PageResponse;
import dev.kelvin.store.platform.Console;
import dev.kelvin.store.platform.PlatformReposity;
import dev.kelvin.store.platform.Platform;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class GameService {
    private final GameRepository gameRepository;
    private final PlatformReposity platformRepository;
    private final GameMapper gameMapper;
    private final CategoryRepository categoryRepository;

    public String saveGame(final GameRequest gameRequest) {

        if (gameRepository.existsByTitle(gameRequest.title())) {
            // todo create a dedicated exception
            log.info("Game already exists:{}", gameRequest.title());
            throw new RuntimeException("Game already exists");
        }

        if (!categoryRepository.existsById(gameRequest.categoryId())){
            log.warn("Category does not exist:{}", gameRequest.categoryId());
            throw new RuntimeException("Category does not exist");
        }

        final List<Console> selectedConsoles = gameRequest.platforms().stream().map(
                Console::valueOf
        ).collect(Collectors.toList());

        final List<Platform> platformList = platformRepository.findAllByConsoleIn(selectedConsoles);

        if (platformList.size() != selectedConsoles.size()) {
            log.warn("Some consoles are not supported, received: {},stored {}",
                    selectedConsoles, platformList);
            throw new RuntimeException("One or more platforms are not supported");
        }

        final Game game = gameMapper.toGame(gameRequest);
        game.setPlatforms(platformList);

        Game saveGame = gameRepository.save(game);

        return saveGame.getId();
    }

    public void updateGame(String gameId, GameRequest gameRequest) {

    }

    public String uploadGameImage(MultipartFile file, String gameId) {
        return null;
    }

    public PageResponse<GameResponse> findAllGames(int page, int size) {
        return null;
    }

    public void deleteGame(String gameId) {

    }

}
