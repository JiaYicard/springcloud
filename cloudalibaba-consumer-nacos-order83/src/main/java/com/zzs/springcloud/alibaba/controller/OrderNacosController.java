package com.zzs.springcloud.alibaba.controller;

import com.zzs.springcloud.alibaba.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author mm013
 * @Date 2021/3/19 14:50
 */

@Slf4j
@RestController
public class OrderNacosController {

    @Resource
    private PaymentFeignService paymentFeignServicel;

    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String paymentInfo(@PathVariable("id") Long id) {
        return paymentFeignServicel.paymentInfo(id);
    }


}
