package com.example.websocket.Service;

import com.example.websocket.DTO.AddMemberRequest;
import com.example.websocket.DTO.RemoveMemberRequest;
import com.example.websocket.Entity.GroupMember;
import com.example.websocket.Entity.GroupMessage;
import com.example.websocket.Repository.ChatGroupRepository;
import com.example.websocket.Repository.GroupMemberRepository;
import com.example.websocket.Repository.GroupMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupChatService {

    private final ChatGroupRepository groupRepository;
    private final GroupMemberRepository memberRepository;
    private final GroupMessageRepository repository;


    public GroupMember addMember(
            AddMemberRequest request) {

        boolean exists =
                memberRepository
                        .findByGroupIdAndUserName(
                                request.getGroupId(),
                                request.getUserName()
                        )
                        .isPresent();

        if (exists) {
            throw new RuntimeException(
                    "User already exists in group"
            );
        }

        GroupMember member =
                new GroupMember();

        member.setGroupId(
                request.getGroupId());

        member.setUserName(
                request.getUserName());

        member.setRole("MEMBER");

        return memberRepository.save(
                member);
    }
    public List<GroupMember> getMembers(
            Long groupId) {

        return memberRepository
                .findByGroupId(groupId);
    }

    public void removeMember(
            RemoveMemberRequest request) {

        memberRepository
                .deleteByGroupIdAndUserName(
                        request.getGroupId(),
                        request.getUserName()
                );
    }

    public GroupMessage saveMessage(
            GroupMessage message) {

        message.setCreatedAt(
                LocalDateTime.now());

        return repository.save(message);
    }

    public List<GroupMessage> getGroupMessages(
            Long groupId) {

        return repository
                .findByGroupIdOrderByCreatedAtAsc(
                        groupId);
    }

}

//    public ChatGroup createGroup(
//            CreateGroupRequest request) {
//
//        ChatGroup group = new ChatGroup();
//
//        group.setGroupName(
//                request.getGroupName());
//
//        group.setCreatedBy(
//                request.getCreatedBy());
//
//        group.setCreatedAt(
//                LocalDateTime.now());
//
//        ChatGroup saved =
//                groupRepository.save(group);
//
//        GroupMember admin =
//                new GroupMember();
//
//        admin.setGroupId(saved.getId());
//
//        admin.setUserId(
//                request.getCreatedBy());
//
//        admin.setRole("ADMIN");
//
//        memberRepository.save(admin);
//
//        return saved;
//    }
//}
