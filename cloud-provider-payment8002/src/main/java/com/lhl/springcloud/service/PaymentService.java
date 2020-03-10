package com.lhl.springcloud.service;

import com.lhl.springcloud.entity.Payment;

/**
 * @author lhl
 * @create 2020/3/9 0:39
 */
public interface PaymentService {

   /* long countByExample(PaymentExample example);

    int deleteByExample(PaymentExample example);*/

    int deleteByPrimaryKey(Long id);

    int add(Payment record);

    /*int insertSelective(Payment record);

    List<Payment> selectByExample(PaymentExample example);
*/
    Payment getByPrimaryKey(Long id);

   /* int updateByExampleSelective(@Param("record") Payment record, @Param("example") PaymentExample example);

    int updateByExample(@Param("record") Payment record, @Param("example") PaymentExample example);

    int updateByPrimaryKeySelective(Payment record);*/

    int updateByPrimaryKey(Payment record);
}
