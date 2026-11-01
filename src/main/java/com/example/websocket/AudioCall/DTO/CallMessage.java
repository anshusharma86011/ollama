package com.example.websocket.AudioCall.DTO;

import lombok.Data;

@Data
public class CallMessage {

    private String type;
    private String callerId;
    private String receiverId;

    private Object offer;

    private Object answer;

    private Object candidate;

    private Object data;
}