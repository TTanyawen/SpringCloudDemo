package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class PayService {
    public String pay() {
        System.out.println("PayService: pay");
        return "Payservice: pay";
    }
}
