package com.example.servicefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(value = "server-hi",fallback = FeignHystrixService.class)
public interface FeignService {

    @RequestMapping(value = "hi",method = RequestMethod.GET)
    String sayHiFromClientOn(@RequestParam(value = "name")String name);
}
