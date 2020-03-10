package com.lhl.springcloud;

import com.lhl.springcloud.dao.PaymentMapper;
import com.lhl.springcloud.entity.Payment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaymentApplication8001Tests {

    @Autowired
    PaymentMapper paymentMapper;


    @Test
    void testDao(){
        Payment payment = new Payment();
        payment.setSerial("fadfd");
        paymentMapper.insert(payment);
    }
}
