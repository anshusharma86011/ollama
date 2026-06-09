package com.example.websocket.Service;

import com.example.websocket.Entity.GroupMessage;
import com.example.websocket.Repository.GroupMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupMessageService {

    private final GroupMessageRepository repository;

    public GroupMessage saveMessage(
            GroupMessage message) {

        message.setCreatedAt(
                LocalDateTime.now());

        return repository.save(message);
    }

    public List<GroupMessage> getHistory(
            Long groupId) {

        return repository
                .findByGroupIdOrderByCreatedAtAsc(
                        groupId
                );
    }
}
