package com.zhang.demo2.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhang.demo2.config.EchoClient;
import com.zhang.demo2.entity.ReqMassage;
import com.zhang.demo2.entity.RequestMassage;
import com.zhang.demo2.entity.ResMassage;
import org.springframework.web.bind.annotation.RequestBody;
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
    @RequestMapping("/request")
    private void request(@RequestBody ReqMassage reqMassage) {
        String s = JSONObject.toJSONString(reqMassage);
        echoClient.send(s);
    }
}
