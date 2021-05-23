package com.lesson_3.controller;

import com.lesson_3.dto.Product;
import com.lesson_3.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/addProduct")
@RequiredArgsConstructor
public class AddProductController {
    private final ProductService productService;

    @PostMapping
    public String addProduct(@ModelAttribute Product product) {
        productService.add(product);
        return "addProd";
    }

}
