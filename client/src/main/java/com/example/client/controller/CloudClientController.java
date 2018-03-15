package com.example.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CloudClientController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "hi")
    public String hello(@RequestParam String name){
        return "hi" + name + ",i am from server port " + port;
    }
}
