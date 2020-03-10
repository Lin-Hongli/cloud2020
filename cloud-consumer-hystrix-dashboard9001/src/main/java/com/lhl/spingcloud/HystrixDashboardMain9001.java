package com.lhl.spingcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author lhl
 * @create 2020/3/10 20:57
 */
@SpringBootApplication
@EnableHystrixDashboard//启用监控
//界面输入要监控的地址http://localhost:8001/hystrix.stream
public class HystrixDashboardMain9001 {
    public static void main(String[] args){
        SpringApplication.run(HystrixDashboardMain9001.class,args);
    }
}
