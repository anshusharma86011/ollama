package com.example.websocket;

import com.example.websocket.ChatMessage;
import com.example.websocket.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository repository;

    public ChatMessage saveMessage(ChatMessage message) {

        message.setCreatedAt(LocalDateTime.now());

        return repository.save(message);
    }


    public List<ChatMessage> getChatHistory(
            String user1,
            String user2) {

        return repository
                .findBySenderIdAndReceiverIdOrSenderIdAndReceiverIdOrderByCreatedAtAsc(
                        user1,
                        user2,
                        user2,
                        user1);
    }

    public List<ChatMessage> getAllMessages() {
        return repository.findAll();
    }
}