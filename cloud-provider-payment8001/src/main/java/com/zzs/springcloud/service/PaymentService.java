package com.zzs.springcloud.service;

import com.zzs.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author mountain
 * @since 2020/12/8 21:39
 */
public interface PaymentService {
    /**
     *  新增
     * @param payment
     * @return
     */
    int add(Payment payment);


    /**
     * 根据id修改
     * @param id
     * @return
     */
    Payment findById(@Param("id") Long id);
}
