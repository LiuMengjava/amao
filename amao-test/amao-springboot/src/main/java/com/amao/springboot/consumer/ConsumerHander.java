package com.amao.springboot.consumer;

import com.amao.springboot.domain.MqResult;

public interface ConsumerHander<R,T> {

    MqResult<R> doHandler(T message, String msgId);

}
