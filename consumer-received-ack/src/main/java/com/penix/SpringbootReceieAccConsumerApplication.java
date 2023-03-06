package com.penix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @program: springboot-rabbitmq-parent
 * @author: Tony.Lai
 * @description:
 * @create: 2023-03-05 15:21
 **/
@SpringBootApplication
@ComponentScan(value = "com.penix.consumer")
public class SpringbootReceieAccConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootReceieAccConsumerApplication.class,args);
    }
}
