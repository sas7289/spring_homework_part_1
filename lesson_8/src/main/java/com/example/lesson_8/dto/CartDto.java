package com.example.lesson_8.dto;

import com.example.lesson_8.model.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CartDto {
    private final List<OrderItem> orderItems;
    private Integer totalPrice;
}
