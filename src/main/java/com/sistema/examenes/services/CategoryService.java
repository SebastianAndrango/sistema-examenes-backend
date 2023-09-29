package com.sistema.examenes.services;

import java.util.Set;

import com.sistema.examenes.models.Category;

public interface CategoryService {
    
    Category addCategory(Category category);

    Category updateCategory(Category category);

    Set<Category> getCategories();

    Category getCategoryById(Long categoryId);

    void deleteCategory(Long categoryId);
}
