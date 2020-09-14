package com.amao.alipay.controller;

import com.amao.alipay.config.AlipayConfig;
import com.amao.alipay.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@RestController
public class Pay {

    @Autowired
    private PayService alipayViewService;

    /**
     * 支付
     */
    @RequestMapping(value = "/pay/{orderId}",method = RequestMethod.GET)
    public void goToPay(@PathVariable Long orderId, HttpServletResponse response) throws IOException {
        Map<String, Object> stringObjectMap = alipayViewService.setGotoPayInfos(orderId);

        response.setContentType("text/html;charset=" + AlipayConfig.input_charset);
        response.getWriter().write((String) stringObjectMap.get("data"));//直接将完整的表单html输出到页面

        response.getWriter().flush();
        response.getWriter().close();
    }
}
