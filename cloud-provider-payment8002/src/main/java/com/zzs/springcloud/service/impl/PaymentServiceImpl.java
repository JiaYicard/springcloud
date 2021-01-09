package com.zzs.springcloud.service.impl;

import com.zzs.springcloud.dao.PaymentDao;
import com.zzs.springcloud.entities.Payment;
import com.zzs.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author mountain
 * @since 2020/12/8 21:40
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
