package com.lhl.springcloud.service.impl;

import com.lhl.springcloud.dao.PaymentMapper;
import com.lhl.springcloud.entity.Payment;
import com.lhl.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lhl
 * @create 2020/3/9 0:40
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper paymentMapper;


    @Override
    public int deleteByPrimaryKey(Long id) {
        int i = paymentMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public int add(Payment record) {
        int i = paymentMapper.insert(record);
        return i;
    }

    @Override
    public Payment getByPrimaryKey(Long id) {
        Payment payment = paymentMapper.selectByPrimaryKey(id);
        return payment;
    }

    @Override
    public int updateByPrimaryKey(Payment record) {
        int i = paymentMapper.updateByPrimaryKey(record);
        return i;
    }
}
