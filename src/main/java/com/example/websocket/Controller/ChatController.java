package com.example.websocket.Controller;

import com.example.websocket.Entity.ChatMessage;
import com.example.websocket.Service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(
            ChatMessage message) {

        return chatService.saveMessage(message);
    }
}