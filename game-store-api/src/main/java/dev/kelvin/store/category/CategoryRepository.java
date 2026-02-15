package dev.kelvin.store.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, String> {

    List<Category> findAllByNameStartingWithIgnoreCaseOOrderByNameAsc(String name);


    @Query("""
                    SELECT c from Category c
                    WHERE c.name like lower(:name)
                    order by c.name asc
            """)
    List<Category> findAllByName(@Param("name") String name);
}
