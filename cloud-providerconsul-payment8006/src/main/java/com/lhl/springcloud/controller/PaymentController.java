package com.lhl.springcloud.controller;


import com.lhl.springcloud.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author lhl
 * @create 2020/3/9 17:18
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/consul")
    public String paymentzk() {
        return "springcloud with consul:" + serverPort + "\t" + UUID.randomUUID().toString();
    }


    @RequestMapping("/payment/consul/{id}")
    public CommonResult paymentzk(@PathVariable("id")Long id) {
        return new CommonResult(200,"查询成功");
    }
}
