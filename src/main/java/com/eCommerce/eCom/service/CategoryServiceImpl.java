package com.eCommerce.eCom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eCommerce.eCom.Repository.CateogoryRepository;
import com.eCommerce.eCom.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService{

  @Autowired
  private CateogoryRepository cateogoryRepository;

    public CategoryServiceImpl(CateogoryRepository cateogoryRepository) {
   this.cateogoryRepository = cateogoryRepository;
}

    @Override
    public List<Category> getAllCategories() {
       return cateogoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
         cateogoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long categoryId) {
    
      cateogoryRepository.deleteById(categoryId);
    
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {

       Category optionalCategory= cateogoryRepository.findById(categoryId);//Manage Expection Later;

       optionalCategory.setCategoryName(category.getCategoryName());
       return cateogoryRepository.save(optionalCategory);
    }
    
}
