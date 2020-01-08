package com.amao.springboot.controller;

import com.amao.springboot.client.RocketMqProducerClient;
import com.amao.springboot.service.DroolsService;
import org.apache.rocketmq.client.producer.SendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class Demo1 {

    @Autowired
    private DroolsService droolsService;
//    @Autowired
//    private RocketMqConsumerClient rocketMqConsumerClient;

    @Autowired
    private RocketMqProducerClient rocketMqProducerClient;
    @RequestMapping(value="/drools",method = RequestMethod.GET)
    public String getString(){
        return droolsService.fireRule();
    }

    @RequestMapping(value = "/sendmsg",method = RequestMethod.GET)
    public String sendmsg(){
        //rocketMqConsumerClient.subscribe("tagA");
        SendResult send = rocketMqProducerClient.send("testmq", "tagA", "mq消息".getBytes());
        return send.getMsgId();
    }
}
