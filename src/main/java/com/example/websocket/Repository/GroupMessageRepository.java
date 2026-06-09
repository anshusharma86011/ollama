package com.example.websocket.Repository;

import com.example.websocket.Entity.GroupMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupMessageRepository extends JpaRepository<GroupMessage,Long> {
    List<GroupMessage> findByGroupIdOrderByCreatedAtAsc(
            Long groupId
    );
}
