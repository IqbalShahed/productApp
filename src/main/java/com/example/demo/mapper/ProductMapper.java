package com.example.demo.mapper;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;

public class ProductMapper {

    // Entity to DTO
    public static ProductDTO toProductDTO(Product product){
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCategory().getId()
        );
    }

    // DTO to Entity
    public static Product toProductEntity(ProductDTO productDTO, Category category){
        Product product = new Product();
        product.setName(product.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(product.getPrice());
        product.setCategory(category);
        return product;
    }
}
