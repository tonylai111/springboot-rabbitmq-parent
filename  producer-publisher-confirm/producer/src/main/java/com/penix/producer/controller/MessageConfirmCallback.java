package com.penix.producer.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @program: springboot-rabbitmq-parent
 * @author: Tony.Lai
 * @description:
 * @create: 2023-03-05 16:15
 **/
@Component
public class MessageConfirmCallback implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback {

    Logger log = LogManager.getLogger(MessageConfirmCallback.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 创建RabbitTemplate 对象之后执行当前方法，为模板对象设置回调确认方法，
     * 设置消息确认对调方法
     * 设置消息回调方法
     */
    @PostConstruct
    public void initRabbitTemplate() {
        //设置消息确认回调方法
        rabbitTemplate.setConfirmCallback(this::confirm);
        rabbitTemplate.setReturnCallback(this::returnedMessage);

    }

    /**
     * 投递到交换机，不论是否成功，都会回调此方法
     *
     * @param correlationData 投递的相关数据
     * @param ack             是否投递到交换机
     * @param cause           投递失败原因
     */

    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        if (ack) {
            log.info("Yeah! 消息进入【交换机】成功");
        } else {
            log.info("呜呜~~，消息进入【交换机】失败，失败原因:{}", cause);
        }
    }

    /**
     * 当消息投递到交换机，只有当exchange路由到queue失败，即交换机到消息队列中出现异常，执行returnMessage方法
     * 正常时是不会调用此方法的
     *
     * @param message    投递消息内容
     * @param replyCode  返回错误的状态码
     * @param replyText  返回错误内容
     * @param exchange   交换机名称
     * @param routingKey 路由键
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        log.info("【交换机】--->【消息队列】出错。。。。。");
        log.info("交换机：" + exchange);
        log.info("路由键:" + routingKey);
        log.info("错误的状态码:" + replyCode);
        log.info("错误内容(原因):" + replyText);
        log.info("发送消息内容:" + message.toString());

    }
}
