package com.lhl.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lhl
 * @create 2020/3/9 2:03
 */
@Configuration
public class RestTemplateConfig {
    @Bean
    @LoadBalanced//开启负载均衡机制
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
