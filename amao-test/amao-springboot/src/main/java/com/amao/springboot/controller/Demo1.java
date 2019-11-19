package com.amao.springboot.controller;

import com.amao.client.RocketMqProducerClient;
import org.apache.rocketmq.client.producer.SendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
public class Demo1 {

    @Autowired
    private RocketMqProducerClient rocketMqProducerClient;

    @RequestMapping(value="/sendmsg",method = RequestMethod.GET)
    public String getString(){
        String body = "springboot简单整合rocketmq";
        SendResult send = null;
        try {
            send = rocketMqProducerClient.send("springboot", "rocketmq", body.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return send.toString();
    }
}
