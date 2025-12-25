package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user")
    public String getUser() {
        return userService.getUser();
    }

    @GetMapping("/user/getpay")
    public String getPay() {
        return userService.getPay();
    }
}
