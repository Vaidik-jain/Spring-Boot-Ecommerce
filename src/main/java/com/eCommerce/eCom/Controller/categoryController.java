package com.eCommerce.eCom.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eCommerce.eCom.model.Category;
import com.eCommerce.eCom.service.CategoryService;

@RestController
@RequestMapping("/api")
public class categoryController {
  
    @Autowired
   private CategoryService categoryService;

    @GetMapping("/public/categories")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories = categoryService.getAllCategories();
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }
    
    @PostMapping("/public/categories")
    public ResponseEntity<String> createCategory(@RequestBody Category category){
        categoryService.createCategory(category);
        return new ResponseEntity<>("Cateory Added",HttpStatus.CREATED);
    }
     
    @DeleteMapping("/admin/categories/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId){
       categoryService.deleteCategory(categoryId);
       return ResponseEntity.ok("deleted"+categoryId);
    }
     @PutMapping("/public/categories/{categoryId}")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category,@PathVariable Long categoryId){
       
        Category updatedCategory=categoryService.updateCategory(category, categoryId);
        return ResponseEntity.ok(updatedCategory);

    }
}
