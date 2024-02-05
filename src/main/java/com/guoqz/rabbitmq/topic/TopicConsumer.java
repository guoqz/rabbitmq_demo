package com.guoqz.rabbitmq.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "topic", type = ExchangeTypes.TOPIC),
                    key = {"user.save", "user.*"}
            )
    })
    public void receive(String message) {
        System.out.println("message1 = " + message);
    }


    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "topic", type = ExchangeTypes.TOPIC),
                    key = {"order.#", "product.#", "user.*"}    // *匹配一个，#匹配多个或零个
            )
    })
    public void receive2(String message) {
        System.out.println("message2 = " + message);
    }

}
