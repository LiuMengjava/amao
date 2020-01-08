package com.amao.springboot.client;

import org.apache.rocketmq.client.producer.SendResult;

public interface RocketMqProducerClient {

    /**
     * 发送二进制消息
     * @param subTopic  子主题,可以是具体业务代码
     * @param bizId  业务id，用于顺序推送消息,可不传
     * @param body 消息内容
     */
    SendResult send(String subTopic, String bizId, byte[] body);

    /**
     * 停止MQ发送客户端
     */
    void shutdown();


}
