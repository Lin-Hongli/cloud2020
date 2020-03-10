package com.lhl.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lhl
 * @create 2020/3/9 18:06
 */
@RestController
@Slf4j
public class OrderZkController {

    /*此处的服务名与eureka不同，eureka为大写*/
    public static final String INVOKE_URL="http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/consumer/payment/zk")
    public String create(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/zk", String.class);
    }
}
