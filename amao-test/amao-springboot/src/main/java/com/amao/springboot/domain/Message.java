package com.amao.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Message {
    private String message;

    private Integer status;
}
