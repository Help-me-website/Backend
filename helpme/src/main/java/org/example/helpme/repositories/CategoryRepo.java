package org.example.helpme.repositories;

import org.example.helpme.domain.Entities.CategoryEntity;
import org.example.helpme.domain.dto.CategoryDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CategoryRepo extends BaseRepo<CategoryEntity, Integer> {
    CategoryEntity findByName(String name);
}
