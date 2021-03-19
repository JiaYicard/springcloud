package com.zzs.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author mm013
 * @Date 2021/3/19 14:53
 */
@Component
@FeignClient("nacos-payment-provider")
public interface PaymentFeignService {

    @GetMapping("/payment/nacos/{id}")
    String paymentInfo(@PathVariable("id") Long id);
}
