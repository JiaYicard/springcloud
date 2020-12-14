package com.zzs.springcloud.service.impl;

import com.zzs.springcloud.dao.PaymentDao;
import com.zzs.springcloud.entity.Payment;
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
    public int add(Payment payment) {
        return paymentDao.add(payment);
    }

    @Override
    public Payment findById(Long id) {
        return paymentDao.findById(id);
    }
}
