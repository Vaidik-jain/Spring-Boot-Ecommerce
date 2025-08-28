package com.eCommerce.eCom.Repository;

import java.util.List;

import com.eCommerce.eCom.model.Category;

public interface CateogoryRepository extends JpaRepository<Category,Long> {

    List<Category> findAll();

    Category save(Category category);

    Category findById(Long categoryId);

    void deleteById(Long categoryId);

    
    
}
