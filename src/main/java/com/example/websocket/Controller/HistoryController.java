package com.example.websocket.Controller;


import com.example.websocket.Entity.ChatMessage;
import com.example.websocket.Service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class HistoryController {
    private final ChatService chatService;

    @GetMapping("/history/{user1}/{user2}")
    public List<ChatMessage> getHistory(
            @PathVariable String user1,
            @PathVariable String user2) {

        return chatService.getChatHistory(
                user1,
                user2);
    }
}
