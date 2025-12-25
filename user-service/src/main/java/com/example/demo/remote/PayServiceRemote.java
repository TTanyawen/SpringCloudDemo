package com.example.demo.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

//@FeignClient(name = "pay-service",url="http://localhost:8085",fallback = PayServiceRemoteFallBack.class)
@FeignClient(name = "pay-service",url="http://localhost:8085")
public interface PayServiceRemote {
    @RequestMapping("/pay")
    String pay();

}
