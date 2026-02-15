package dev.kelvin.store.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GameRepository extends JpaRepository<Game, String>, JpaSpecificationExecutor<Game> {


    @Query("SELECT EXISTS(SELECT 1 FROM Game g WHERE g.title = :title)")
    boolean existsByTitle(@Param("title") String title);
}
