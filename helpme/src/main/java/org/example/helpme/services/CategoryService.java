package org.example.helpme.services;

import org.example.helpme.domain.Entities.CategoryEntity;
import org.example.helpme.repositories.CategoryRepo;

public class CategoryService {
    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public Iterable<CategoryEntity> getAllCategories() {
        return categoryRepo.findAll();
    }
    public void addCategory(CategoryEntity category) {
        categoryRepo.save(category);
    }

    public void removeCategory(CategoryEntity category) {
        categoryRepo.delete(category);
    }

    public void updateCategory(CategoryEntity category) {
        categoryRepo.delete(category);
    }
}
