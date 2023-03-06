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
 * @create: 2023-03-03 16:05
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class Demo01TestSimpleQueue {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendMsg() {
        for (int i = 0; i < 1000; i++) {
            rabbitTemplate.convertAndSend("simple_quque", "hello world rabbitmq"+i+"次！");
        }
    }

}
