package com.amao.alipay.service;


import java.util.Map;

public interface PayService {
    Map<String, Object> setGotoPayInfos(Long orderId);
}
