package com.lesson_3.controller;

import com.lesson_3.dto.Product;
import com.lesson_3.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductListController {
    private final ProductService productService;

    @GetMapping
    @ModelAttribute("products")
    public List<Product> getHtml() {
//        model.addAttribute("products", productService.findAll());
        return productService.findAll();
    }
}
