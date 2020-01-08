package com.amao.springboot.client;

import com.amao.springboot.consumer.ConsumerHanderImpl;
import com.amao.springboot.domain.Message;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Configuration
public class RocketMqConsumerClientImpl implements RocketMqConsumerClient {
    private static final Logger logger = LoggerFactory.getLogger(RocketMqConsumerClientImpl.class);

    private DefaultMQPushConsumer pushConsumer;
    @Autowired
    private ApplicationContext applicationContext;
    private final String TOPIC = "testmq";
    private final String TAG = "tagA";


    // 构造函数中设置消费者信息
    public RocketMqConsumerClientImpl(){
        pushConsumer = new DefaultMQPushConsumer("consumertest");
        pushConsumer.setNamesrvAddr("106.13.180.38:9876");
        pushConsumer.setMessageModel(MessageModel.CLUSTERING);
    }
    @Override
    public void shutdown() {
        if (null != pushConsumer) {
            pushConsumer.shutdown();
        }
    }

    // 服务启动的时候启动消费者
    @PostConstruct
    public void init(){
        this.subscribe(this.TAG);
    }

    @Override
    public void subscribe(String subTopic) {
        try {
            pushConsumer.subscribe("testmq",subTopic);
        } catch (MQClientException e) {
            logger.info("消息订阅失败");
            e.printStackTrace();
        }

        pushConsumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                for (MessageExt messageExt : msgs) {
                    // 处理消息
                    ConsumerHanderImpl hander = applicationContext.getBean(TOPIC, ConsumerHanderImpl.class);
                    hander.doHandler(new Message(new String(messageExt.getBody()),1),messageExt.getMsgId());
//                    String messageBody = new String(messageExt.getBody());
//                    System.err.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(
//                            new Date())+"消费响应：msgId : " + messageExt.getMsgId() + ",  msgBody : " + messageBody);//输出消息内容
                }

                //返回消费状态
                //CONSUME_SUCCESS 消费成功
                //RECONSUME_LATER 消费失败，需要稍后重新消费
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        try {
            pushConsumer.start();
            System.out.println("Consumer Started");
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }
}
