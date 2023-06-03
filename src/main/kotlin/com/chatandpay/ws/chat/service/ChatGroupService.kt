package com.chatandpay.ws.chat.service

import com.chatandpay.ws.chat.entity.GroupUser
import com.chatandpay.ws.chat.repository.ChatGroupMessageRepository
import com.chatandpay.ws.chat.repository.GroupUserRepository
import org.bson.types.ObjectId
import org.springframework.stereotype.Service
import java.util.*

@Service()
class ChatGroupService (
    private val chatGroupMessageRepository:ChatGroupMessageRepository,
    private val groupUserRepository:GroupUserRepository
){


    // 그룹 유저 저장
    fun createGroupMember(users:List<ObjectId>):List<GroupUser>{

        try {
            val groupId = ObjectId();
            val groupUsers = users.map{userId ->
                GroupUser(groupId = groupId, userId = userId);
            }
            return groupUserRepository.saveAll(groupUsers);

        } catch (e: Exception) { e.printStackTrace()
            throw ChatRoomService.ChatRoomCreationException("Failed to save group users", e)
        }
    }

}