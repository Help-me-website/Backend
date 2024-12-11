package org.example.helpme.repository;

import org.example.helpme.model.entity.CategoryEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends BaseRepository<CategoryEntity, Integer> {
    CategoryEntity findByName(String name);
}
