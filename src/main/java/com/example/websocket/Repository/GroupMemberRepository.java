package com.example.websocket.Repository;

import com.example.websocket.Entity.GroupMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GroupMemberRepository extends JpaRepository<GroupMember,Long> {

    List<GroupMember> findByGroupId(Long groupId);
    Optional<GroupMember> findByGroupIdAndUserName(
            Long groupId,
            String userName
    );

    void deleteByGroupIdAndUserName(
            Long groupId,
            String userName
    );

}
