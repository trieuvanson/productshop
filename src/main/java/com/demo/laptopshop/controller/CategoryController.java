package com.demo.laptopshop.controller;


import com.demo.laptopshop.exception.ResourceNotFoundException;
import com.demo.laptopshop.model.Category;
import com.demo.laptopshop.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    CategoryRepo categoryRepo;

    @GetMapping("/")
    private List<Category> getCategorys()  {
        return categoryRepo.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id)    {
        Category Category = categoryRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Category not exist " + id));
        return ResponseEntity.ok(Category);
    }

    @PostMapping("/")
    public Category PostCategory(@RequestBody Category Category) {
        return categoryRepo.save(Category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> PutCategory(@RequestBody Category Category, @PathVariable Long id)  {
        Category newCategory = categoryRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Category not exist " + id));
        newCategory.setName(Category.getName());
        Category updateCategory = categoryRepo.save(newCategory);
        return ResponseEntity.ok(updateCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCategory(@PathVariable Long id)    {
        Category Category = categoryRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Category not exist " + id));
        categoryRepo.delete(Category);
        Map<String, Boolean> reponse = new HashMap<>();
        reponse.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(reponse);
    }
}
