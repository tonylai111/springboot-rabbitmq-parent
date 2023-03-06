package com.penix.cosumer.message;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-rabbitmq-parent
 * @author: Tony.Lai
 * @description:
 * @create: 2023-03-05 15:30
 **/
@Component
@RabbitListener(queues = "order.A")
public class MessageListener {

    @RabbitHandler
    public void handlerMsg(String msg) {
        System.out.println("接收到消息" + msg);
    }

}
