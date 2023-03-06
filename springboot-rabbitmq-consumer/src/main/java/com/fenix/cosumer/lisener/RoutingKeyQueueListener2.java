package com.fenix.cosumer.lisener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-rabbitmq-parent
 * @author: Tony.Lai
 * @description:
 * @create: 2023-03-04 14:43
 **/
@Component
@RabbitListener(queues = "routing_queue2")
public class RoutingKeyQueueListener2 {
    @RabbitHandler
    public void routingKeyMsgHandler(String msg){
        System.out.println("RoutingKeyQueueListener2收到消息:"+msg);
    }
}
