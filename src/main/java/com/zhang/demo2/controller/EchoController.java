package com.zhang.demo2.controller;

import com.zhang.demo2.config.EchoClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class EchoController {
    @Resource
    EchoClient echoClient;

    @RequestMapping("/send")
    private void send(String massage) {
        echoClient.send(massage);
    }
}
