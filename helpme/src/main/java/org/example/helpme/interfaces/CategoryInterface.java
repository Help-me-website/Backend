package org.example.helpme.interfaces;

import org.example.helpme.models.Category;

import java.util.List;

public interface CategoryInterface {
    // anyone
    public List<Category> getCategories();
    // must be a user
    public void addCategory(Category category);
}
