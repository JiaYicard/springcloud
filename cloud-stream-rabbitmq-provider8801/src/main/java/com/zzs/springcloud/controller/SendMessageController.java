package com.zzs.springcloud.controller;

import com.zzs.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author mm013
 * @Date 2021/3/17 16:45
 */

@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider iMessageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage() {

        return iMessageProvider.sendMsg();
    }
}
