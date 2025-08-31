package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private CategoryRepository categoryRepository;
    private ProductRepository productRepository;

    //Create Product
    public ProductDTO createProduct(ProductDTO productDTO){
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(()-> new RuntimeException("Category not found"));

        // DTO -> Entity
        Product product = ProductMapper.toProductEntity(productDTO, category);
        product = productRepository.save(product);

        // Entity -> DTO
        return  ProductMapper.toProductDTO(product);
    }

    // Get all products
    public List<ProductDTO> getAllProducts(){
        return productRepository.findAll()
                .stream().map(ProductMapper::toProductDTO).toList();
    }

    // Get product by id
    public ProductDTO getProductById(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found!"));
        return ProductMapper.toProductDTO(product);
    }

    // Update product
    public ProductDTO updateProduct(Long id, ProductDTO productDTO){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found!"));
        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found!"));
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setCategory(category);
        productRepository.save(product);
        return ProductMapper.toProductDTO(product);
    }

    // Delete product
    public String deleteProduct(Long id){
        productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found!"));
        productRepository.deleteById(id);
        return "Product " + id + " has been deleted!";
    }
}