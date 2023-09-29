package com.sistema.examenes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.examenes.models.Category;
import com.sistema.examenes.services.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
    
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        Category categorySave = categoryService.addCategory(category);
        return ResponseEntity.ok(categorySave);
    }

    @GetMapping("/{categoryId}")
    public Category getCategoryById(@PathVariable("categoryId")Long categoryId){
        return categoryService.getCategoryById(categoryId);
    }

    @GetMapping("/")
    public ResponseEntity<?> getCategories(){
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @PutMapping("/")
    public Category updateCategory(@RequestBody Category category){
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/")
    public void deleteCategory(@PathVariable("categoryId")Long categoryId){
        categoryService.deleteCategory(categoryId);
    }
}
