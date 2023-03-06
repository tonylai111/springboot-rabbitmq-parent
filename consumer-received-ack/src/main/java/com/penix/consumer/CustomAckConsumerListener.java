package com.penix.consumer;

import com.rabbitmq.client.Channel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;



/**
 * @program: springboot-rabbitmq-parent
 * @author: Tony.Lai
 * @description:
 * @create: 2023-03-05 17:20
 **/
@Component
public class CustomAckConsumerListener implements ChannelAwareMessageListener {

    Logger log = LogManager.getLogger(CustomAckConsumerListener.class);

    /**
     * 监听消息的内容
     *
     * @param message
     * @param channel
     * @throws Exception
     */
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        //1、获取消息内容
        byte[] messageBody = message.getBody();
        String msg = new String(messageBody, "utf-8");
        log.info("接收到消息，执行具体业务逻辑，消息内容：{}", msg);
        MessageProperties messageProperties = message.getMessageProperties();
        //2、获取投递消息标签
        long deliveryTag = messageProperties.getDeliveryTag();
        //3、签收消息，前提，必须在监听器的配置中，开启手动前后模式
        /*
            参数1：deliveryTag 消息投递标签
           参数2：是否批量签收，true一次签收所有，false，只是签收当前消息
         */
        //只签收当前消息
        try {
            if (msg.contains("业务异常标识")) {
                throw new RuntimeException("模拟业务异常场景");
            }
            channel.basicAck(deliveryTag, false);
            log.info("手动签收完成。。。");
        } catch (Exception e) {
            /**
             * 手动拒绝签收：
             * 参数一：当前投递的标签，
             * 参数二：是否批量签收，true一次性签收所有，false，签收当前
             * 参数三：是否重回队列 : true 重回队列 ，false：不重回队列
             */

            channel.basicNack(deliveryTag, false, true);
            log.info("出现异常：拒绝签收消息,滚回去到队列中去,原因：{}", e.getMessage());
        }

    }
}
