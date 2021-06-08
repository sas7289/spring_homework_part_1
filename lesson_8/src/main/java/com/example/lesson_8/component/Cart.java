package com.example.lesson_8.component;

import com.example.lesson_8.dto.CartDto;
import com.example.lesson_8.model.OrderItem;
import com.example.lesson_8.model.Product;
import com.example.lesson_8.service.ProductService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@SessionScope
public class Cart {
    private final ProductService productService;
    private final List<OrderItem> orderItems;
    private Integer totalPrice;

    public CartDto getCartDto() {
        return new CartDto(orderItems, totalPrice);
    }

    public Cart(ProductService productService) {
        this.productService = productService;
        this.orderItems = new ArrayList<>();
        this.totalPrice = calculateTotalPrice();
    }

    public void addProduct(Long productId) {
        OrderItem orderItem = orderItems.stream()
                .filter(it -> it.getProductId().equals(productId))
                .findFirst()
                .orElseGet(() -> {
                    Product product = productService.findById(productId);
                    OrderItem tempOrderItem = new OrderItem(product.getId(), product.getTitle(), product.getCost(), 0);
                    orderItems.add(tempOrderItem);
                    return tempOrderItem;
                });
        orderItem.setQuantity(orderItem.getQuantity() + 1);
        totalPrice = calculateTotalPrice();
    }

    public void deleteProduct(Long productId) {
        Optional<OrderItem> orderItem = orderItems.stream()
                .filter(it -> it.getProductId().equals(productId))
                .findFirst();
        if(orderItem.isPresent()) {
            final OrderItem item = orderItem.get();
            if (item.getQuantity() == 0) {
                return;
            }
            item.setQuantity(item.getQuantity() - 1);
            totalPrice = calculateTotalPrice();
        }
    }

    public void clear() {
        orderItems.clear();
        totalPrice = 0;
    }

    private Integer calculateTotalPrice() {
         return orderItems.stream()
                .map(it -> it.getProductPrice() * it.getQuantity())
                .reduce(0, Integer::sum);
    }
}
