package com.lhl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lhl
 * @create 2020/3/10 16:48
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix//开启熔断
public class OrderHystrixMain80 {
    public static void main(String[] args){
        SpringApplication.run(OrderHystrixMain80.class,args);
    }
}
