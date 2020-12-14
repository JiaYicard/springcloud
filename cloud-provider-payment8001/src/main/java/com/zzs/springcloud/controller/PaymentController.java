package com.zzs.springcloud.controller;

import com.zzs.springcloud.conmmon.CommonResult;
import com.zzs.springcloud.entity.Payment;
import com.zzs.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author mountain
 * @since 2020/12/8 22:14
 */
@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @RequestMapping(value = "payment/add",method = RequestMethod.POST)
    private CommonResult add(Payment payment){
        int result=paymentService.add(payment);
        log.info("********* 插入结果"+result);
        return CommonResult.success("添加成功");
    }

    @RequestMapping(value = "payment/findById",method = RequestMethod.GET)
    private CommonResult findById(Long id){
        return CommonResult.success(paymentService.findById(id));
    }
}


