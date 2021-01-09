package com.zzs.springcloud.dao;

import com.zzs.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author mountaion
 * @since 2020/12/8 21:34
 */
@Mapper
public interface PaymentDao {
    /**
     *  新增
     * @param payment
     * @return
     */
    int create(Payment payment);


    /**
     * 根据id修改
     * @param id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);
}
