package com.lhl.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lhl
 * @create 2020/3/9 19:51
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsul80 {
    public static void main(String[] args){
        SpringApplication.run(OrderConsul80.class,args);
    }
}
