package com.example.demo.controller;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
@AllArgsConstructor
public class CategoryController {
    private CategoryService categoryService;

    // Create Category
    @PostMapping
    public CategoryDTO categoryDTO(@RequestBody CategoryDTO categoryDTO){
        return (categoryService.createCategory(categoryDTO));
    }
}
