package com.example.lesson_5.service;

import com.example.lesson_5.dto.ProductDto;
import com.example.lesson_5.repository.ProductRepository;
import com.example.lesson_5.util.ConverterUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(ConverterUtil::productToDto)
                .collect(Collectors.toList());
    }

    public Long save(ProductDto productDto) {
        if (productDto.getId() == null) {
            return productRepository.create(ConverterUtil.dtoToProduct(productDto)).getId();
        } else {
            return productRepository.update(ConverterUtil.dtoToProduct(productDto)).getId();
        }
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
