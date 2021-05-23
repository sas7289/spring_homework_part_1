package com.example.lesson_8.controller;

import com.example.lesson_8.model.Product;
import com.example.lesson_8.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("app/v1")
public class ProductController {
    private final ProductService service;
    private Page<Product> productPages;

    @GetMapping("/products")
    public List<Product> findAll(@RequestParam Map<String, String> params/*, @RequestParam(required = false) Integer page*/) {
        Pageable pages = PageRequest.of(0,3);
        productPages = service.findAll(params, pages);
        return productPages.getContent();
    }

    @GetMapping("/prev")
    public List<Product> prevPage(@RequestParam Map<String, String> params) {
        if(!productPages.hasPrevious()) {
            return service.findAll(params, productPages.getPageable()).getContent();
        }
        productPages = service.findAll(params, productPages.previousOrFirstPageable());
        return productPages.getContent();
    }

    @GetMapping("/next")
    public List<Product> nextPage(@RequestParam Map<String, String> params) {
        if(!productPages.hasNext()) {
            return service.findAll(params, productPages.getPageable()).getContent();
        }
        productPages = service.findAll(params, productPages.nextPageable());
        return productPages.getContent();
    }


    @PostMapping("/save")
    public void saveProduct(@RequestBody Product product) {
        service.saveProduct(product);
    }

    @PostMapping("/delete")
    public void deleteProduct(@RequestBody Product product) {
        service.delete(product);
    }
}
