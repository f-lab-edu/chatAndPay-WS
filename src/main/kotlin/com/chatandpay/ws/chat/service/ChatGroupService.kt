package com.chatandpay.ws.chat.service

import com.chatandpay.ws.chat.repository.ChatGroupMessageRepository
import com.chatandpay.ws.chat.repository.GroupUserRepository
import org.springframework.stereotype.Service

@Service()
class ChatGroupService (
    private val chatGroupMessageRepository:ChatGroupMessageRepository,
    private val groupUserRepository:GroupUserRepository
){




}