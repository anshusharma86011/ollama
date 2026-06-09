package com.example.websocket.DTO;

import lombok.Data;

@Data
public class RemoveMemberRequest {
    private Long groupId;

    private String userName;
}
