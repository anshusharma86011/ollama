package com.example.websocket.AudioCall.Controller;


import com.example.websocket.AudioCall.DTO.CallMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class CallController {

    @MessageMapping("/call")
    @SendTo("/topic/call")
    public CallMessage handleCall(CallMessage message) {
        System.out.println("CALL RECEIVED => " + message);
        return message;
    }
}