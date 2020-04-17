package com.example.demo.MQUtil;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @author: ZPX
 * @createDate: 2020/4/18 3:32
 * @version: 1.0
 */
@Service
public class MessageProducerServiceImpl {
    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    /*  *//**
     * 向默认队列发送消息
     *
     * @param msg
     *//*
    public void sendMsgD(String msg) {
        jmsMessagingTemplate.convertAndSend(new ActiveMQQueue(MQQueueType.MQ_DEFAULT), msg);
    }
*/
    /**
     * 向指定队列发送消息
     *
     * @param queueName 指定队列名称
     * @param msg       消息内容
     */
    public void sendMsgO(String queueName, String msg) {
        jmsMessagingTemplate.convertAndSend(new ActiveMQQueue(queueName), msg);
    }

}





