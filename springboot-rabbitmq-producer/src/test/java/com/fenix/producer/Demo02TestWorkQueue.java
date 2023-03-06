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
 * @create: 2023-03-03 17:12
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class Demo02TestWorkQueue {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSendWorkingQueue() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work_queue", "我是工作队列消息呀！");
        }
    }
}
