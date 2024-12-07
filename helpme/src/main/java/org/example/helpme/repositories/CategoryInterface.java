package org.example.helpme.repositories;

import org.example.helpme.domain.dto.CategoryDTO;

import java.util.List;

public interface CategoryInterface {
    // anyone
    public List<CategoryDTO> getCategories();
    // must be a user
    public void addCategory(CategoryDTO categoryDTO);
}
