package com.example.websocket.DTO;

import lombok.Data;

@Data
public class AddMemberRequest {
    private Long groupId;

    private String userName;
}

