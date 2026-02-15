package dev.kelvin.store.platform;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface PlatformReposity extends JpaRepository<Platform, String> {

    @Query("""
        SELECT p from Platform p where p.console in :selectedConsoles
    """)
    List<Platform> findAllByConsoleIn(@Param("selectedConsoles") List<Console> selectedConsoles);
}
