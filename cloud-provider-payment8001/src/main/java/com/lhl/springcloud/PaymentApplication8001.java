package com.lhl.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author LinHongLi
 * @create 2020-3-8 22:23
 */
@MapperScan("com.lhl.springcloud.dao")
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient//发现服务
public class PaymentApplication8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication8001.class,args);
    }
}
