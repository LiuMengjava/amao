package com.amao.producer;

import com.amao.pojo.OrderDO;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderProducer {
    public static void main(String[] args) throws IOException {
        try {
            DefaultMQProducer producer = new DefaultMQProducer("sequence_producer");

            producer.setNamesrvAddr("10.43.104.25:9876");

            producer.start();

            String[] tags = new String[] { "TagA", "TagC", "TagD"};

            // 订单列表
            List<OrderDO> orderList =  new OrderProducer().buildOrders();

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateStr = sdf.format(date);
            for (int i = 0; i < 10; i++) {
                // 加个时间后缀
                String body = dateStr + " Hello RocketMQ " + orderList.get(i).getOrderId()+orderList.get(i).getDesc();
                Message msg = new Message("SequenceTopicTest", tags[i % tags.length], "KEY" + i, body.getBytes());

                SendResult sendResult = producer.send(msg, new MessageQueueSelector() {
                    @Override
                    public MessageQueue select(List<MessageQueue> mqs, Message msg, Object arg) {
                        Long id = Long.valueOf((String)arg);
                        long index = id % mqs.size();
                        return mqs.get((int)index);
                    }
                }, orderList.get(i).getOrderId());//通过订单id来获取对应的messagequeue

                System.out.println("msgId:"+sendResult.getMsgId() + ", body:" + body);
            }

            producer.shutdown();

        } catch (MQClientException e) {
            e.printStackTrace();
        } catch (RemotingException e) {
            e.printStackTrace();
        } catch (MQBrokerException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 生成模拟订单数据
     */
    private List<OrderDO> buildOrders() {
        List<OrderDO> orderList = new ArrayList<OrderDO>();

        OrderDO OrderDO = new OrderDO();
        OrderDO.setOrderId("15103111039");
        OrderDO.setDesc("创建");
        orderList.add(OrderDO);

        OrderDO = new OrderDO();
        OrderDO.setOrderId("15103111065");
        OrderDO.setDesc("创建");
        orderList.add(OrderDO);

        OrderDO = new OrderDO();
        OrderDO.setOrderId("15103111039");
        OrderDO.setDesc("付款");
        orderList.add(OrderDO);

        OrderDO = new OrderDO();
        OrderDO.setOrderId("15103117235");
        OrderDO.setDesc("创建");
        orderList.add(OrderDO);

        OrderDO = new OrderDO();
        OrderDO.setOrderId("15103111065");
        OrderDO.setDesc("付款");
        orderList.add(OrderDO);

        OrderDO = new OrderDO();
        OrderDO.setOrderId("15103117235");
        OrderDO.setDesc("付款");
        orderList.add(OrderDO);

        OrderDO = new OrderDO();
        OrderDO.setOrderId("15103111065");
        OrderDO.setDesc("完成");
        orderList.add(OrderDO);

        OrderDO = new OrderDO();
        OrderDO.setOrderId("15103111039");
        OrderDO.setDesc("推送");
        orderList.add(OrderDO);

        OrderDO = new OrderDO();
        OrderDO.setOrderId("15103117235");
        OrderDO.setDesc("完成");
        orderList.add(OrderDO);

        OrderDO = new OrderDO();
        OrderDO.setOrderId("15103111039");
        OrderDO.setDesc("完成");
        orderList.add(OrderDO);
        return orderList;
    }

}
