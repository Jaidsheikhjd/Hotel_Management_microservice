package com.user.service.user_service.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class config {
    
    @Bean
    @LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
