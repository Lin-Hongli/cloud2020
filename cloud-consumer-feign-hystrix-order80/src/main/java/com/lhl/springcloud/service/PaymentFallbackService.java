package com.lhl.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * 为某个服务的所有方法定义统一的服务降级处理
 * @author lhl
 * @create 2020/3/10 18:55
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{

    @Override
    public String paymentInfo_OK(Integer id) {
        return "PaymentFallbackService统一服务降级处理paymentInfo_OK";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService统一服务降级处理paymentInfo_TimeOut";
    }
}
