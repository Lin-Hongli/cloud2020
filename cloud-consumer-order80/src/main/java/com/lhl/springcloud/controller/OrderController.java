package com.lhl.springcloud.controller;

import com.lhl.springcloud.entity.CommonResult;
import com.lhl.springcloud.entity.Payment;
import com.lhl.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author lhl
 * @create 2020/3/9 1:59
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private LoadBalancer loadBalancer;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/consumer/payment")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment",payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/"+id,CommonResult.class);
    }


    //自定义负载算法
    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances=discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances==null||instances.size()<=0){
            return null;
        }

        ServiceInstance serviceInstance=loadBalancer.instance(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }
}
