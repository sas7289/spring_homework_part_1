package com.example.lesson_5.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private Long id;
    private String title;
    private Integer cost;
    private Integer version;
    private Boolean isDeleted;
}
