package com.example.lesson_8.controller;

import com.example.lesson_8.model.Product;
import com.example.lesson_8.model.User;
import com.example.lesson_8.service.BucketService;
import com.example.lesson_8.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app/v1/bucket")
public class BucketController {
    private final UserService userService;
    private final BucketService bucketService;

    @PostMapping("/save")
    public void saveBucket(@RequestBody Product product, Principal principal) {
        if (principal == null) {
            bucketService.save(product.getId(), 0l);
        }
        User user = userService.findByUserName(principal.getName()).orElseThrow(()->
                new UsernameNotFoundException(String.format("User %s not found", principal.getName())));
        bucketService.save(product.getId(), user.getId());
    }
}
