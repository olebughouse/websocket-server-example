package com.example.websocketserver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Controller
public class MessageWSController {

    // get incoming message
    @MessageMapping("/incoming")
    // send incoming message further to another channel
    @SendTo("/ws/ping/outgoing")
    public OutputMessage send(Message message) {
        log.info("Incoming message: {}", message.getText());
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getFrom(), message.getText(), time);
    }
}
