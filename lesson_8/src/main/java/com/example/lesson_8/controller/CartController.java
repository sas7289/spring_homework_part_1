package com.example.lesson_8.controller;

import com.example.lesson_8.component.Cart;
import com.example.lesson_8.dto.CartDto;
import com.example.lesson_8.model.OrderItem;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final Cart cart;

    @GetMapping
    public CartDto getCart() {
        return cart.getCartDto();
    }

    @PutMapping
    public void addProduct(@RequestBody Long productId) {
        cart.addProduct(productId);
    }

    @DeleteMapping
    public void deleteProduct(@RequestParam(name = "product_id") Long productId) {
        cart.deleteProduct(productId);
    }

    @DeleteMapping("clear")
    public void  clearCart() {
        cart.clear();
    }
}
