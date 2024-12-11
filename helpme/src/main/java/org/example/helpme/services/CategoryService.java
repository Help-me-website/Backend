package org.example.helpme.services;

import org.example.helpme.model.entity.CategoryEntity;
import org.example.helpme.repository.CategoryRepository;

public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Iterable<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }
    public void addCategory(CategoryEntity category) {
        categoryRepository.save(category);
    }

    public void removeCategory(CategoryEntity category) {
        categoryRepository.delete(category);
    }

    public void updateCategory(CategoryEntity category) {
        categoryRepository.delete(category);
    }
}
