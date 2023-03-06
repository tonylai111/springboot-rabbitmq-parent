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
 * @create: 2023-03-04 14:57
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo05TopicTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendTopicMsg() {
        for (int i = 0; i < 1000; i++) {
            if (i % 3 == 0) {
                rabbitTemplate.convertAndSend("topic_exchange", "item.hello.2", "发动匹配一个消息");
            } else if (i % 3 == 1) {
                rabbitTemplate.convertAndSend("topic_exchange", "item.yes", "发动匹配一个item.*的消息");
            } else {
                rabbitTemplate.convertAndSend("topic_exchange", "item3", "发动匹配一个item3的消息");
            }
        }

    }

}
