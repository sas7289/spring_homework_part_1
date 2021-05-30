package com.example.lesson_8.util;

import com.example.lesson_8.dto.CategoryDto;
import com.example.lesson_8.dto.ProductDto;
import com.example.lesson_8.model.Category;
import com.example.lesson_8.model.Product;

public class Convert {
    public static Category dtoToCategory(CategoryDto dto) {
        return new Category(dto.getId(), dto.getName());
    }

    public static CategoryDto categoryToDto(Category category) {
        return new CategoryDto(category.getId(), category.getName());
    }

    public static Product dtoToProduct(ProductDto dto) {
        return new Product(dto.getId(), dto.getTitle(), dto.getCost(), new Category(null, dto.getCategory()));
    }

    public static ProductDto productToDto(Product product) {
        return new ProductDto(product.getId(), product.getTitle(), product.getCost(), product.getCategory().getName());
    }
    
}
