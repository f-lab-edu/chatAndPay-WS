package com.chatandpay.ws.chat.service

import com.chatandpay.ws.chat.dto.CreateGroupRoomRequestDto
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




}