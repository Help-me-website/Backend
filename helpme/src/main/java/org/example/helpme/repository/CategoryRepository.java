package org.example.helpme.repository;

import org.example.helpme.model.entity.CategoryEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends BaseRepository<CategoryEntity, Integer> {
    CategoryEntity findByName(String name);
    Optional<CategoryEntity> findByCategoryId(Integer id);
}
