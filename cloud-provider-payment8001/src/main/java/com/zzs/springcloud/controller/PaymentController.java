package com.zzs.springcloud.controller;
import com.zzs.springcloud.common.CommonResult;
import com.zzs.springcloud.entities.Payment;
import com.zzs.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author mountain
 * @since 2020/12/8 22:14
 */
@Slf4j
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private PaymentService paymentService;

    @RequestMapping(value = "payment/create",method = RequestMethod.POST)
    private CommonResult add(Payment payment){
        int result=paymentService.create(payment);
        log.info("********* 插入结果"+result);
        return CommonResult.success("添加成功");
    }

    @RequestMapping(value = "payment/get/{id}",method = RequestMethod.GET)
    private CommonResult getPaymentById(@PathVariable("id") Long id)  {
        return CommonResult.success(paymentService.getPaymentById(id));
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}

