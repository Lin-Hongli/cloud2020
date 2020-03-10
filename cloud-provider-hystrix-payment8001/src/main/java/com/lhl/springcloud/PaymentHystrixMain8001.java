package com.lhl.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * @author lhl
 * @create 2020/3/10 1:45
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker//断路器，开启熔断功能
public class PaymentHystrixMain8001 {
    public static void main(String[] args){
        SpringApplication.run(PaymentHystrixMain8001.class,args);
    }

    //坑：被hystrix-dashboard监控的服务需要添加如下配置
    //被监控地址即是http://localhost:8001/hystrix.stream
    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet=new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean=new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
