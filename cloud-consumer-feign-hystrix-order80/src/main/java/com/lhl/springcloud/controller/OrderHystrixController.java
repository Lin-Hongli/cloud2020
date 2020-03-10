package com.lhl.springcloud.controller;

import com.lhl.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author lhl
 * @create 2020/3/10 16:51
 */
@RestController
@Slf4j
//定义本类全局的降级处理
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_OK(id);
        return result;
    }


//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//    })
    @HystrixCommand//指明此方法需要降级
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        int i=1/0;
        String result = paymentHystrixService.paymentInfo_TimeOut(id);
        return result;
    }

    /**
     * follback,兜底方案，超时时的解决方案
     * @return
     */
    public String paymentInfo_TimeOutHandler(@PathVariable("id") Integer id){
        return "消费端超时" + id +"系统忙";
    }


    //设置全局的默认降级方法
    public String payment_Global_FallbackMethod(){
        return "全局降级方法.....";
    }
}
