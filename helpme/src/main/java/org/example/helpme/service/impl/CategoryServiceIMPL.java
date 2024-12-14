package org.example.helpme.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.helpme.mapper.Mapper;
import org.example.helpme.model.dto.CategoryDTO;
import org.example.helpme.model.entity.CategoryEntity;
import org.example.helpme.repository.CategoryRepository;
import org.example.helpme.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceIMPL implements CategoryService {
  private final CategoryRepository categoryRepository;
  private final Mapper<CategoryEntity, CategoryDTO> categoryMapper;

  @Override
  public Iterable<CategoryDTO> getAllCategories() {
    List<CategoryEntity> categories = categoryRepository.findAll();
    return categories
            .stream()
            .map(categoryMapper::toDto)
            .collect(Collectors.toList());
  }

  @Override
  public CategoryDTO getCategoryById(Integer id) {
    CategoryEntity categoryEntity = categoryRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Category not found"));
    return categoryMapper.toDto(categoryEntity);
  }

  @Override
  public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
    CategoryEntity categoryEntity = categoryMapper.toEntity(categoryDTO);
    categoryEntity = categoryRepository.save(categoryEntity);
    return categoryMapper.toDto(categoryEntity);
  }

  @Override
  public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
    CategoryEntity categoryEntity = categoryMapper.toEntity(categoryDTO);
    categoryEntity = categoryRepository.save(categoryEntity);
    return categoryMapper.toDto(categoryEntity);
  }

  @Override
  public Void deleteCategory(Integer id) {
    categoryRepository.deleteById(id);
    return null;
  }
}
