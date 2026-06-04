package com.example.websocket.Controller;

import com.example.websocket.Entity.ChatMessage;
import com.example.websocket.Service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class ChatRestController {
    private final ChatService chatService;

    @GetMapping("/messages")
    public List<ChatMessage> getMessages() {

        return chatService.getAllMessages();
    }
}
