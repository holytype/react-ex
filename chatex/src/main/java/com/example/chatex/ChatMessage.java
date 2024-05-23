package com.example.chatex;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChatMessage {
    private Long id;
    private String name;
    private String message;
}
