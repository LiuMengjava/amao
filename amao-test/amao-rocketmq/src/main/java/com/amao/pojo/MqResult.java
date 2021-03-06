package com.amao.pojo;

import lombok.Data;

@Data
public class MqResult<T> {
    private Boolean success;
    private String msgId;
    private String errorCode;
    private String errorMsg;
    private T data;
}
