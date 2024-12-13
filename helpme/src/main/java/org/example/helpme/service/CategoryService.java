package org.example.helpme.service;

import org.example.helpme.mapper.CategoryMapper;
import org.example.helpme.model.dto.CategoryDTO;
import org.example.helpme.model.entity.CategoryEntity;
import org.example.helpme.repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public Iterable<CategoryDTO> getAllCategories() {
        List<CategoryEntity> categories = categoryRepository.findAll();
        return categories
                .stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }
    public void addCategory(CategoryDTO category) {
        categoryRepository.save(categoryMapper.toEntity(category));
    }

    public void removeCategory(CategoryDTO category) {
        categoryRepository.delete(categoryMapper.toEntity(category));
    }

    public void updateCategory(CategoryDTO category) {
        categoryRepository.delete(categoryMapper.toEntity(category));
    }
}
