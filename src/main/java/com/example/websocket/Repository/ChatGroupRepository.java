package com.example.websocket.Repository;

import com.example.websocket.Entity.ChatGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatGroupRepository extends JpaRepository<ChatGroup,Long> {
}
