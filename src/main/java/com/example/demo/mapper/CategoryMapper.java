package com.example.demo.mapper;

import com.example.demo.dto.CategoryDTO;
import com.example.demo.entity.Category;

public class CategoryMapper {

    // Entity to DTO
    public static CategoryDTO toCategoryDTO(Category category){
        if(category == null){
            return null;
        }
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setProducts(category.getProdducts().stream()
                .map(ProductMapper::toProductDTO).toList());
        return categoryDTO;
    }

    // DTO to Entity
    public static Category toCategoryEntity(CategoryDTO categoryDTO){
        Category category = new Category();
        category.setName(categoryDTO.getName());
        return category;
    }
}
