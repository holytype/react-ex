package com.example.chatex;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessageSendingOperations template;
    /*convertAndSend(String destination, Object payload): 주어진 목적지로 메시지를 보냅니다. 이 메서드는 메시지를 지정된 대상에 전송하고 메시지의 내용을 변환하는 데 사용됩니다.
    convertAndSendToUser(String user, String destination, Object payload): 특정 사용자에게 메시지를 보냅니다. 주로 사용자별 개인 메시지를 보낼 때 사용됩니다.
    convertAndSendToSession(String sessionId, String destination, Object payload): 특정 세션에 메시지를 보냅니다. WebSocket 세션에 메시지를 전송하는 데 사용됩니다.*/

    // 요청한 채팅방의 메시지를 보냅니다.
    @GetMapping("/chat/{id}")
    public ResponseEntity<List<ChatMessage>> getChatMessages(@PathVariable Long id) {
        // DB파트 임시로 데이터를 만들어 보냅니다.
        ChatMessage test = new ChatMessage(1L,"test","test");
        return ResponseEntity.ok().body(List.of(test));
    }

    // 메세지 통신을 처리합니다.
    // /ws/pub
    @MessageMapping("/message")
    public ResponseEntity<Void> receiveMessage(@RequestBody ChatMessage message) {
        template.convertAndSend("/sub/chatroom/1", message);
        return ResponseEntity.ok().build();
    }
}
