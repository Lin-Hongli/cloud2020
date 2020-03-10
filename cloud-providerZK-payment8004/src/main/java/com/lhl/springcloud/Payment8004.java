package com.lhl.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lhl
 * @create 2020/3/9 17:16
 */
@SpringBootApplication
@EnableDiscoveryClient //用于向使用consul或zookeeper作为注册中心时注册服务
public class Payment8004 {
    public static void main(String[] args) {
        SpringApplication.run(Payment8004.class,args);
    }
}
