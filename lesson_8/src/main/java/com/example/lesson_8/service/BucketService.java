package com.example.lesson_8.service;

import com.example.lesson_8.repository.BucketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BucketService {
    private final BucketRepository bucketRepository;

    public void save(Long productId, Long userId) {
        bucketRepository.saveProductsToBucket(productId, userId);
    }
}
