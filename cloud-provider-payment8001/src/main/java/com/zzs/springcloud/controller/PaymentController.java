package com.zzs.springcloud.controller;
import com.zzs.springcloud.common.CommonResult;
import com.zzs.springcloud.entities.Payment;
import com.zzs.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "payment/create",method = RequestMethod.POST)
    private CommonResult add(@RequestBody Payment payment){
        int result=paymentService.create(payment);
        log.info("********* 插入结果"+result);
        return CommonResult.success("添加成功：端口为"+serverPort);
    }

    @RequestMapping(value = "payment/get/{id}",method = RequestMethod.GET)
    private CommonResult getPaymentById(@PathVariable("id") Long id)  {
        return CommonResult.success(paymentService.getPaymentById(id)+"端口号为: "+serverPort);
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    /**
     * 获取服务的信息
     * @return
     */
    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
}

