package com.sap.springily.dao;

import com.sap.springily.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
//@Repository//会有问题
public interface PaymentDao {
    //增删改查 按ID查 分页查等等
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
