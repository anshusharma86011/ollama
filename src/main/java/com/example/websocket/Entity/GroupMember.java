package com.example.websocket.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "group_members")
@Data
public class GroupMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long groupId;
    private String userName;
    private String role;

}
