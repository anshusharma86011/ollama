package com.example.websocket.Controller;



import com.example.websocket.DTO.AddMemberRequest;
import com.example.websocket.DTO.RemoveMemberRequest;
import com.example.websocket.Entity.GroupMember;
import com.example.websocket.Service.GroupChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/groups")
@RequiredArgsConstructor
@CrossOrigin("*")
public class GroupController {

    private final GroupChatService groupService;

//    @PostMapping("/create")
//    public ChatGroup createGroup(
//            @RequestBody
//            CreateGroupRequest request) {
//
//        return groupService.createGroup(
//                request);
//    }
    @PostMapping("/add-member")
    public GroupMember addMember(
            @RequestBody
            AddMemberRequest request) {

        return groupService.addMember(
                request);
    }
    @GetMapping("/{groupId}/members")
    public List<GroupMember> getMembers(
            @PathVariable Long groupId) {

        return groupService.getMembers(groupId);
    }
    @DeleteMapping("/remove-member")
    public String removeMember(
            @RequestBody
            RemoveMemberRequest request) {

        groupService.removeMember(request);

        return "Member Removed";
    }
}
