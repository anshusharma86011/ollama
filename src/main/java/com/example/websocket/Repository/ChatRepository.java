package com.example.websocket.Repository;

import com.example.websocket.Entity.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChatRepository
        extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findBySenderIdAndReceiverIdOrSenderIdAndReceiverIdOrderByCreatedAtAsc(
            String sender1,
            String receiver1,
            String sender2,
            String receiver2);
}