package com.example.RabbitMQPublish;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class RMQClient {

    @Autowired
    private Channel channel;

    public void sendMsg(String message){
        try {
            channel.basicPublish("test_exchange","test_routing_key",
                    MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
