package com.example.websocket.Controller;

import com.example.websocket.Entity.GroupMessage;
import com.example.websocket.Service.GroupMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class GroupChatController {

    private final GroupMessageService service;

    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/group.send")
    public void sendGroupMessage(
            GroupMessage message) {

        GroupMessage saved =
                service.saveMessage(message);

        messagingTemplate.convertAndSend(
                "/topic/group/" +
                        message.getGroupId(),
                saved
        );
    }

//    @PostMapping("/message")
//    public GroupMessage save(
//            @RequestBody GroupMessage message) {
//
//        return service.saveMessage(message);
//    }
}