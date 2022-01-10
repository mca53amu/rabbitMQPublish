package com.example.RabbitMQPublish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MyController {

    @Autowired
    private RMQClient rmqClient;

    @GetMapping("/publish/{message}")
    public String test(@PathVariable String message) throws IOException {
        rmqClient.sendMsg(message);
        return "Success";
    }
}
