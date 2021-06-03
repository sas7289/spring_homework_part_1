package com.example.lesson_8.controller;

import com.example.lesson_8.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("app/v1/")
public class UserController {
    private final UserService userService;

    @GetMapping("bucket")
    public String getUserBucket(Principal principal) {
        return principal.getName();
    }

}
