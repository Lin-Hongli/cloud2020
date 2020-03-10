package com.lhl.springcloud.controller;

import com.lhl.springcloud.entity.CommonResult;
import com.lhl.springcloud.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lhl
 * @create 2020/3/9 1:59
 */
@RestController
@Slf4j
public class OrderConsulController {

    public static final String INVOKE_URL="http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/consumer/payment/consul")
    public String getPayment1(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/consul", String.class);
    }

    @GetMapping("/consumer/payment/getForEntity/consul/{id}")
    public CommonResult getPayment2(@PathVariable("id")Long id){
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(INVOKE_URL + "/payment/consul/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()){
            log.info(forEntity.getStatusCode()+"\t"+forEntity.getHeaders());
            return forEntity.getBody();
        }else{
            return new CommonResult(444,"操作失败");
        }
    }
}
