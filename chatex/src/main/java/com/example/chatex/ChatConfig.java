package com.example.chatex;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;


@Configuration
@EnableWebSocketMessageBroker
public class ChatConfig implements WebSocketMessageBrokerConfigurer {

    // stomp로 연결할 Endpoint를 설정합니다.
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws") // endpoint를 /ws로 설정 합니다.
                .setAllowedOrigins("*"); // 모든 도메인에서의 연결을 허용합니다.
    }

    // 메세지 브로커를 설정합니다.
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // 구독자의 메세지 수신 endpoint를 설정합니다.
        registry.enableSimpleBroker("/sub");
        // 발행자가 메세지 송신 할 endpoint를 설정합니다.
        registry.setApplicationDestinationPrefixes("/pub");
    }
}
