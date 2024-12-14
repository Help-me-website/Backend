package org.example.helpme.service;

import org.example.helpme.model.dto.CategoryDTO;

public interface CategoryService {
  Iterable<CategoryDTO> getAllCategories();
  CategoryDTO getCategoryById(Integer id);
  CategoryDTO saveCategory(CategoryDTO categoryDTO);
  CategoryDTO updateCategory(CategoryDTO categoryDTO);
  Void deleteCategory(Integer id);
}
