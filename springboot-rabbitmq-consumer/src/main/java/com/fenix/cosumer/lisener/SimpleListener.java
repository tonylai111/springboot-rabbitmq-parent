package com.fenix.cosumer.lisener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-rabbitmq-parent
 * @author: Tony.Lai
 * @description:
 * @create: 2023-03-03 16:43
 **/
@Component
@RabbitListener(queues = "simple_quque")
public class SimpleListener {

    @RabbitHandler
    public void simpleHandler(String msg){
        System.out.println("====接收消息==>"+ msg);
    }
}
