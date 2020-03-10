package com.lhl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lhl
 * @create 2020/3/10 0:01
 */
@SpringBootApplication
@EnableFeignClients//开启feign的功能,自带轮询负载均衡
public class OrderFeignMain80 {
    public static void main(String[] args){
        SpringApplication.run(OrderFeignMain80.class,args);
    }
}
