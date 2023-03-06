package com.fenix.cosumer.lisener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-rabbitmq-parent
 * @author: Tony.Lai
 * @description:
 * @create: 2023-03-03 17:15
 **/
@RabbitListener(queues = "work_queue")
@Component
public class WorkQueueListener2 {
    @RabbitHandler
    public void workQueueHandler(String msg){
        System.out.println("消费者2接收到消息"+ msg);
    }
}
