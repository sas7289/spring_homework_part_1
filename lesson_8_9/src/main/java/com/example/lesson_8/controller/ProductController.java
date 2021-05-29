package com.example.lesson_8.controller;

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
    public Page<Product> findAll(@RequestParam Map<String, String> params,
                                 @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
                                 @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize) {
        return productService.findAll(params, pageNumber, pageSize);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") Long id) {
        return productService.findById(id);
    }

    @PutMapping
    public Product updateProduct(@RequestParam Product product) {
        return productService.saveProduct(product);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteById(id);
    }

//    @GetMapping("/prev")
//    public List<Product> prevPage(@RequestParam Map<String, String> params) {
//        if(!productPages.hasPrevious()) {
//            return productService.findAll(params, productPages.getPageable()).getContent();
//        }
//        productPages = productService.findAll(params, productPages.previousOrFirstPageable());
//        return productPages.getContent();
//    }
//
//    @GetMapping("/next")
//    public List<Product> nextPage(@RequestParam Map<String, String> params) {
//        if(!productPages.hasNext()) {
//            return productService.findAll(params, productPages.getPageable()).getContent();
//        }
//        productPages = productService.findAll(params, productPages.nextPageable());
//        return productPages.getContent();
//    }


//    @PostMapping("/delete")
//    public void deleteProduct(@RequestBody Product product) {
//        productService.delete(product);
//    }
}
