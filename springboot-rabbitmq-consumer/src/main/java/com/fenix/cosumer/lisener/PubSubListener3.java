package com.fenix.cosumer.lisener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-rabbitmq-parent
 * @author: Tony.Lai
 * @description:
 * @create: 2023-03-03 17:54
 **/
@RabbitListener(queues = "fanout_exchange_queue2")
@Component
public class PubSubListener3 {
    @RabbitHandler
    public void handPubSubMsg(String msg){
        System.out.println("订阅者3收到消息：====>"+msg);
    }
}
