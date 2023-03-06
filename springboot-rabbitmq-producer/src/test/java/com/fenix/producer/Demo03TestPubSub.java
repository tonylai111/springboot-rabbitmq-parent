package com.fenix.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



@SpringBootTest
@RunWith(SpringRunner.class)
public class Demo03TestPubSub {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testPubSubQueueMsg(){
        for (int i = 0; i < 1000; i++) {
        rabbitTemplate.convertAndSend("fanout_exchange","","发送发布订阅消息"+i);
        }
    }
}
