package com.example.demo.service;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.Category;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository categoryRepository;
    // Create Category
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category);
        return CategoryMapper.toCategoryDTO(category);
    }

    // Get all categories
    public List<CategoryDTO> getAllCategories(){
        return categoryRepository.findAll()
                .stream().map(CategoryMapper::toCategoryDTO).toList();
    }

    // Get category by id
    public CategoryDTO getCategoryById(Long id){
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found!"));
        return CategoryMapper.toCategoryDTO(category);
    }

    // Delete Category
    public String deleteCategory(Long id){
        categoryRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Category Not found"));
        categoryRepository.deleteById(id);
        return "Category " + id + " has been deleted!";
    }
}
