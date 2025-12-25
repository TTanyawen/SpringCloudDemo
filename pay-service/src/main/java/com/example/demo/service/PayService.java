package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class PayService {
    public String pay() {
        // 模拟服务调用失败
        if (Math.random() < 0.99) {
            throw new RuntimeException("服务调用失败");
        }
        System.out.println("PayService: pay");
        return "Payservice: pay";
    }
}
