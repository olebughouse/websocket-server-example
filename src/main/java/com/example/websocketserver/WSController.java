package com.example.websocketserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class WSController {

    @Autowired
    private SimpMessagingTemplate webSocket;

    @GetMapping("up")
    public void sendUpMessage() {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        OutputMessage ping =  new OutputMessage("BACKEND", "PING", time);

        webSocket.convertAndSend("/ws/up", ping);
    }
}
