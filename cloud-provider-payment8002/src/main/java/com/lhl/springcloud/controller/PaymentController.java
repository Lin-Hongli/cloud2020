package com.lhl.springcloud.controller;

import com.lhl.springcloud.entity.CommonResult;
import com.lhl.springcloud.entity.Payment;
import com.lhl.springcloud.service.impl.PaymentServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @author lhl
 * @create 2020/3/9 1:02
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.add(payment);

        log.info("*****插入结果:"+result);

        if (result > 0) {
            return new CommonResult(200,"插入数据库成功",result);
        }else {
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id){
        Payment result = paymentService.getByPrimaryKey(id);

        log.info("*****获取结果:"+result);

        if (result!=null) {
            return new CommonResult(200,"查询成功+serverPort"+serverPort,result);
        }else {
            return new CommonResult(444,"没有对应记录失败，查询"+id,null);
        }
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

}
