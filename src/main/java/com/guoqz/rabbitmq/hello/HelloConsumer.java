package com.guoqz.rabbitmq.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
// 持久化  非独占 不自动删除
@RabbitListener(queuesToDeclare = @Queue(value = "hello",declare = "",autoDelete = "",exclusive = ""))
public class HelloConsumer {

    @RabbitHandler
    public void receive(String message){
        System.out.println("message = " + message);
    }

}
