package com.example.websocketserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {

        // message broker channel for outgoing messages, is this correct? As far as I understood, there is only one broker for all?
        config.enableSimpleBroker("/ws");

        // prefix for incoming messages routed further to @MessageMapping annoted methods, e.g.:
        // send uri "/app/chat" is routed to @MessageMapping("/chat")
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        // endpoint uri for making up an websocket connection
        registry.addEndpoint("/backend").setAllowedOrigins("http://localhost:4200");
        registry.addEndpoint("/backend").setAllowedOrigins("http://localhost:4200").withSockJS();
    }
}
