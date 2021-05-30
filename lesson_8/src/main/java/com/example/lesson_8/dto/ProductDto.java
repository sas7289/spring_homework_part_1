package com.example.lesson_8.dto;

import com.example.lesson_8.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDto {
    private Long id;

    private String title;

    private int cost;

    private String category;
}
