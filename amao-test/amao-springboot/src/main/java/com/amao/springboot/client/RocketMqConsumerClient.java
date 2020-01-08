package com.amao.springboot.client;

import com.amao.springboot.domain.Message;

import java.util.Map;

// 可以封装多个不同需求(有序,无序)的客户端
public interface RocketMqConsumerClient {

    void shutdown();

    /**
     * 订阅普通消息
     * @param subTopic 订阅子主题 可以是业务代码 多个以|| 分开
     */
    void subscribe(String subTopic);
}
