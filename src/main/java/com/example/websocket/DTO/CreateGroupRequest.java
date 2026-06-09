package com.example.websocket.DTO;


import lombok.Data;

@Data
public class CreateGroupRequest {

    private String groupName;

    private String createdBy;
}
