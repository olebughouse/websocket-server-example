package com.example.websocketserver;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PingCronJob {

    @Autowired
    private SimpMessagingTemplate webSocket;

    @Scheduled(fixedDelay = 1000)
    public void scheduleFixedDelayTask() {
        log.debug("Ping - {}", System.currentTimeMillis() / 1000);
        webSocket.convertAndSend("/ws/ping", new Ping("BACKEND"));
    }
}
