package com.example.websocket.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;


@Entity
@Table(name = "group_messages")
@Data
public class GroupMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long groupId;

    private String senderId;

    private String content;

    private LocalDateTime createdAt;
}
