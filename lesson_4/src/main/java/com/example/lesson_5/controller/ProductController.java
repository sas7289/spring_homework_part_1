package com.example.lesson_5.controller;

import com.example.lesson_5.dto.ProductDto;
import com.example.lesson_5.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("products", productService.findAll());
        return "product";
    }

    @PostMapping
    public String addProduct(@ModelAttribute ProductDto product) {
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/{id}")
    public String deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return "redirect:/product";
    }
}
