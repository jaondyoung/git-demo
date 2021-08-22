package cn.ly.jvm.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class SendController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("send")
    public void send(){
        String context = "hello" + LocalDateTime.now();
        System.out.println(context);
        amqpTemplate.convertAndSend("amq.direct","helloQueue",context);
    }


}
