package com.lhl.springcloud.service;

import com.lhl.springcloud.entity.CommonResult;
import com.lhl.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lhl
 * @create 2020/3/10 0:02
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")//微服务名

public interface PaymentFeignService {
    //服务端的接口
    @GetMapping(value = "/payment/{id}")
    CommonResult getPaymentById(@PathVariable("id")Long id);

    @GetMapping("/payment/feign/timeout")
    String paymentFeignTimeout();
}
