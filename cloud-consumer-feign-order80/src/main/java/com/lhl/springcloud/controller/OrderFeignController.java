package com.lhl.springcloud.controller;

import com.lhl.springcloud.entity.CommonResult;
import com.lhl.springcloud.entity.Payment;
import com.lhl.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lhl
 * @create 2020/3/10 0:15
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")Long id){
        return paymentFeignService.getPaymentById(id);
    }

    //测试feign超时
    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        //openfeign-ribbon,客户端默认等待一秒钟
        return paymentFeignService.paymentFeignTimeout();
    }

}
