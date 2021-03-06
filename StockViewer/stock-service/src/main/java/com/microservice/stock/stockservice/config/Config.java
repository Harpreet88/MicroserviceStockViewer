package com.microservice.stock.stockservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {

    @LoadBalanced //client side load taken care here over cloud
    @Bean
    //created new everytime
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
