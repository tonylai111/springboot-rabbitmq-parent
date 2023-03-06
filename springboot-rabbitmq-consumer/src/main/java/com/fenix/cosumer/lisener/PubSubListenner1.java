package com.fenix.cosumer.lisener;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: springboot-rabbitmq-parent
 * @author: Tony.Lai
 * @description:
 * @create: 2023-03-03 17:44
 **/
@RabbitListener(queues = "fanout_exchange")
@Component
public class PubSubListenner1 {

    @RabbitHandler
    public void handlerPubSubMsg(String msg){
        System.out.println("订阅者1收到消息：====>"+msg);
    }
}
