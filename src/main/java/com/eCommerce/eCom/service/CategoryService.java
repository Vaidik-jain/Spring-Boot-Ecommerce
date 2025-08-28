package com.eCommerce.eCom.service;

import java.util.List;



import com.eCommerce.eCom.model.Category;


public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);
    void deleteCategory(Long categoryId);
    Category updateCategory(Category category, Long categoryId);
}
