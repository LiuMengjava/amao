package com.amao.alipay.service;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.amao.alipay.config.AlipayConfig;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class PayServiceImpl implements PayService {
    @Override
    public Map<String, Object> setGotoPayInfos(Long orderId) {
        Map<String, Object> map = new HashMap<>();
        if(StringUtils.isEmpty(orderId)){
            map.put("code", 400);
            map.put("msg", "订单id为空");
            return map;
        }
        /* 查询订单信息 暂时没有持久层 先空着 */
        //PayParameterForm payParameter = orderMapper.getPayParameter(orderId);
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.url, AlipayConfig.app_id, AlipayConfig.private_key, AlipayConfig.format, AlipayConfig.input_charset, AlipayConfig.public_key, AlipayConfig.sign_type);//支付宝需要的参数serverUrl、appId、private_key、format、charset、public_key、signType
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
        /*AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();
        model.setBody("阿毛的测试用例");//商品信息
        model.setSubject("阿毛");//商品名称
        model.setOutTradeNo(String.valueOf(123456));//订单号
        model.setTimeoutExpress("30m");//支付超时时间
*//*
        model.setTotalAmount(String.valueOf(payParameter.getActualPrice()));// 支付金额
*//*
        model.setTotalAmount(String.valueOf(0.01));// 支付金额
        request.setBizModel(model);*/
        // 回调地址(充值订单)
        request.setNotifyUrl(AlipayConfig.notify_url);// 回调地址
        request.setReturnUrl(AlipayConfig.return_url);
        request.setBizContent("{\"out_trade_no\":\""+ orderId +"\","
                + "\"total_amount\":\""+ 0.01 +"\","
                + "\"subject\":\""+ "amao" +"\","
                + "\"body\":\""+ "测试" +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //这里和普通的接口调用不同，使用的是sdkExecute
        String response = null;
        try {
            response = alipayClient.pageExecute(request).getBody();
            map.put("code", 200);
            map.put("msg", "成功");
            /*Map<String, Object> dataMap = new HashMap<>();
            dataMap.put("payPath", response);*/
            map.put("data", response);
            return map;
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        map.put("code", 400);
        map.put("msg", "失败");
        return map;

    }
}
