package com.penix.consumer;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: springboot-rabbitmq-parent
 * @author: Tony.Lai
 * @description: 消费者监听器配置类，绑定到消息队列上
 * @create: 2023-03-05 17:41
 **/
@Configuration
public class ListenerConfiguration {

    @Bean
    public MessageListenerAdapter messageListenerAdapter(CustomAckConsumerListener customAckConsumerListener) {
        return new MessageListenerAdapter(customAckConsumerListener);
    }

    /**
     * 注入消息监听器容器
     *
     * @param connectionFactory      连接工程
     * @param messageListenerAdapter 自定义的消息监听器适配器
     * @return
     */
    @Bean
    public SimpleMessageListenerContainer simpleMessageListenerContainer(ConnectionFactory connectionFactory
            , MessageListenerAdapter messageListenerAdapter) {
        //1、new简单消息监听器容器对象
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        //2、绑定消息队列
        container.setQueueNames("order.A");
        //3、设置连接工厂对象
        container.setConnectionFactory(connectionFactory);
        //4.设置消息监听器适配器
        container.setMessageListener(messageListenerAdapter);
        //5、设置手动确认消息：NONE(不确认)，MANUAL(手动确认),AUTO(自动确认)
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); //手动确认
        return container;
    }


}
