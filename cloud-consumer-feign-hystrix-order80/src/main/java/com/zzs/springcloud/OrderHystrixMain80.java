package com.zzs.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author mountain
 * @since 2021/3/9 21:04
 */

@EnableHystrix
@EnableFeignClients
@SpringBootApplication
public class OrderHystrixMain80  {
    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80 .class, args);
    }
}
