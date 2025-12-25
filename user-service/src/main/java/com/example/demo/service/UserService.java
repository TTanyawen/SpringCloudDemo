package com.example.demo.service;

import com.example.demo.remote.PayServiceRemote;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class UserService {
    @Autowired
    private PayServiceRemote payServiceRemote;
    public String getUser() {
        return "user";
    }

    /*

     */
    @CircuitBreaker(name = "breaker01", fallbackMethod = "fallback")
    public String getPay() throws InterruptedException {
        Thread.sleep(3000); // 模拟慢调用，超过 1 秒
        return payServiceRemote.pay();
    }
    public String fallback(Throwable t) {
        return "服务暂时不可用，请稍后再试";
    }




}
