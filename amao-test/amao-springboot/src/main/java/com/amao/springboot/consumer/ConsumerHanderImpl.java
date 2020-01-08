package com.amao.springboot.consumer;

import com.amao.springboot.domain.Message;
import com.amao.springboot.domain.MqResult;
import org.springframework.stereotype.Service;

@Service("testmq")
public class ConsumerHanderImpl implements ConsumerHander<String, Message> {

    @Override
    public MqResult<String> doHandler(Message message, String msgId) {
        System.err.println("接收到消息"+message.getMessage());
        return null;
    }
}
