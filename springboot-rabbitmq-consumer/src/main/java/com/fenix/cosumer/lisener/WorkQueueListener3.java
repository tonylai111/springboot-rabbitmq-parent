package com.fenix.cosumer.lisener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-rabbitmq-parent
 * @author: Tony.Lai
 * @description:
 * @create: 2023-03-03 17:20
 **/
@Component
@RabbitListener(queues = "work_queue")
public class WorkQueueListener3 {
    @RabbitHandler
    public void workQueueHandler(String msg){
        System.out.println("消费者3接收到消息"+ msg);
    }
}
