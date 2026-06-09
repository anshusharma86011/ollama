package com.example.websocket.Controller;


import com.example.websocket.Entity.GroupMessage;
import com.example.websocket.Service.GroupMessageService;
import com.example.websocket.Service.GroupChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/group-chat")
@RequiredArgsConstructor
@CrossOrigin("*")
public class GroupChatRestController {

    private final GroupMessageService service;
    private final GroupChatService groupChatService;

    @GetMapping("/{groupId}")
    public List<GroupMessage> history(
            @PathVariable Long groupId) {

        return service.getHistory(groupId);
    }

    @GetMapping("/{groupId}/messages")
    public List<GroupMessage> getMessages(
            @PathVariable Long groupId) {

        return groupChatService.getGroupMessages(groupId);

    }

}
