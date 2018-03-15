package com.example.servicefeign.service;

import org.springframework.stereotype.Component;

@Component
public class FeignHystrixService implements FeignService{
    @Override
    public String sayHiFromClientOn(String name) {
        return "sorry,"+name;
    }
}
