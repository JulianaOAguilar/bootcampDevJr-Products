package com.abutua.product_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {
    
    @GetMapping("hello")
    public String getHello(){
        return "Hello Spring Boot";
    }
}
