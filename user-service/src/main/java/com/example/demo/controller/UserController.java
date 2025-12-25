package com.example.demo.controller;

import com.example.demo.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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
    public String getPay() throws InterruptedException {
        return userService.getPay();
    }

    @GetMapping("/user/callService")
    @CircuitBreaker(name = "breaker02", fallbackMethod = "fallback2")
    public String callService() {
        // 模拟服务调用
        if (Math.random() < 0.5) {
            throw new RuntimeException("服务调用失败");
        }
        return "服务调用成功";
    }

    public String fallback2(Throwable t) {
        return "服务暂时不可用，请稍后再试。";
    }
}
//我有一个多模块项目，user-service和pay-service，现在我想新建一个gateway-service来统一访问接口并转发请求，并在请求到来时做一些权限校验(模拟就可以，打印一句话)