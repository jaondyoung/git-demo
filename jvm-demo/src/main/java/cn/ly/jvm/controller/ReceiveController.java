package cn.ly.jvm.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiveController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @RabbitListener(queues = "helloQueue")
    @RequestMapping("receive")
    public String receive(String hello){
        Object message = amqpTemplate.receiveAndConvert("helloQueue");
        System.out.println("Receive:" + message);
        return message.toString();
    }
}
