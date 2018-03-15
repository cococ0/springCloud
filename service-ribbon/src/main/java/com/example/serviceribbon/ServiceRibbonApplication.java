package com.example.serviceribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
/**
 * ribbon是一个负载均衡客户端
 * Spring cloud有两种服务调用方式：
 * 一种是ribbon+restTemplate
 * 另一种是feign
 * */
@EnableDiscoveryClient//向服务中心注册
@SpringBootApplication
@EnableHystrix//开启hystrix
public class ServiceRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRibbonApplication.class, args);
	}

	@Bean
	@LoadBalanced//开启负载均衡功能
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
