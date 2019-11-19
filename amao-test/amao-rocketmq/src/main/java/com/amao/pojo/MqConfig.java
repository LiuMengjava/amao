package com.amao.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

@Data
public class MqConfig {
    /**
     * 服务地址列表
     */
    @Value("${server.ip}")
    private String mqNamesrvAddr;
    /**
     * 消息生产方或订阅方集群代码
     */
    @Value("${groupname}")
    private String groupName;
}
