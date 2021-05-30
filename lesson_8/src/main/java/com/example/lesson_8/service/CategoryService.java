package com.example.lesson_8.service;

import com.example.lesson_8.dto.CategoryDto;
import com.example.lesson_8.model.Category;
import com.example.lesson_8.repository.CategoryRepository;
import com.example.lesson_8.util.Convert;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(Convert::categoryToDto)
                .collect(Collectors.toList());
    }
}
