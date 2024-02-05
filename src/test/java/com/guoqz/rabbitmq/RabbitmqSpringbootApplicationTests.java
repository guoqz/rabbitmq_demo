package com.guoqz.rabbitmq;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqSpringbootApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // hello
    @Test
    void testHello() {
        rabbitTemplate.convertAndSend("hello", "hello RabbitMQ");
    }

    // work     随机发送给一个消费者  轮询
    @Test
    void testWork() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work", "work模型" + i);
        }
    }


    // fanout   广播
    @Test
    void testFanout() {
        rabbitTemplate.convertAndSend("logs", "", "Fanout的模型数据");
    }


    // route 路由模式
    @Test
    void testRoute() {
        rabbitTemplate.convertAndSend("directs", "error", "发送error的key的路由信息");
    }


    // topic    动态路由    订阅模式
    @Test
    void testTopic(){
        rabbitTemplate.convertAndSend("topic","product.save.add","product.save.add 路由消息");
    }

}
