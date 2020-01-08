package com.amao.springboot.client;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.stereotype.Service;

@Service
public class RocketMqProducerClientImpl implements RocketMqProducerClient {

    private DefaultMQProducer producer = null;

    public RocketMqProducerClientImpl(){
        producer = new DefaultMQProducer("producer1");
        producer.setNamesrvAddr("106.13.180.38:9876");
        try{
            producer.start();
        }catch (MQClientException e){
            e.printStackTrace();
        }
    }

    @Override
    public SendResult send(String topic, String tag, byte[] body) {
        Message message = new Message(topic,tag,body);
        SendResult send = null;
        try {
            send = producer.send(message);
        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return send;
    }

    @Override
    public void shutdown() {
        producer.shutdown();
    }
}
