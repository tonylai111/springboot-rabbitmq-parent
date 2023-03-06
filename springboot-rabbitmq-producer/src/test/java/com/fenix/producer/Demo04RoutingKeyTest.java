package com.fenix.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: springboot-rabbitmq-parent
 * @author: Tony.Lai
 * @description:
 * @create: 2023-03-04 14:36
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class Demo04RoutingKeyTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendRoutingKeyMsg() {
        for (int i = 0; i < 1000; i++) {
            if (i % 2 == 0) {
                rabbitTemplate.convertAndSend("routing_exchange", "info", "发送路由绑定key的info消息" + i);
            } else {
                rabbitTemplate.convertAndSend("routing_exchange", "error", "发送路由绑定key的error消息"+i);
            }
        }

    }

}
