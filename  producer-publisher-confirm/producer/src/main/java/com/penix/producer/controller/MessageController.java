package com.penix.producer.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springboot-rabbitmq-parent
 * @author: Tony.Lai
 * @description:
 * @create: 2023-03-05 15:26
 **/
@RestController
@RequestMapping("/msg")

public class MessageController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     *1、如何保证生产者百分百将消息发送给消息队列
     * 什么是否会失败呢，两种情况
     * 第一、发送给MQ失败，消息丢失
     * 第二、交换机路由到队列失败，路由键写错了
     * 消息可靠投递的两种模式： confirm确认模式和return回退模式
     *1)确认模式：
     * 不论消息是否成功投递至交换机，都回调confirm方法，只有在发送失败时需要写业务代码
     * 进行处理。
     * 2)退回模式
     * 消息进入交换机后，只有当从exchange路由到queue失败，才去回调returnedMessage方
     * 法；
     * @param exchange
     * @param routingKey
     * @param msg
     */

    @GetMapping("/send")
    public void sendMsg(String exchange, String routingKey,String msg) {
        //"order_exchange","order.A","路由模式发送了一条消息"
        rabbitTemplate.convertAndSend(exchange, routingKey, msg);
        System.out.println("消息已投递");
    }

}
