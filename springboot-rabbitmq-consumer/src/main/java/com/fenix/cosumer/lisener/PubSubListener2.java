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
@RabbitListener(queues = "fanout_exchange_queue1")
@Component
public class PubSubListener2 {

    @RabbitHandler
    public void handPubSubMsg(String msg) {
        System.out.println("订阅者2" +
                "收到消息：====>"+msg);
    }

}
