package com.example.lesson_8.controller;

import com.example.lesson_8.dto.CategoryDto;
import com.example.lesson_8.dto.ProductDto;
import com.example.lesson_8.model.Product;
import com.example.lesson_8.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("app/v1")
public class ProductController {
    private final ProductService productService;

    @GetMapping("/products")
    public Page<ProductDto> findAll(@RequestParam Map<String, String> params,
                                 @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
                                 @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize) {
        Page<ProductDto> page = productService.findAll(params, pageNumber, pageSize);
        return page;
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") Long id) {
        return productService.findById(id);
    }

    @PutMapping
    public Product updateProduct(@RequestParam ProductDto productDto) {
        return productService.saveProduct(productDto);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductDto productDto) {
        productService.saveProduct(productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
    }

}
