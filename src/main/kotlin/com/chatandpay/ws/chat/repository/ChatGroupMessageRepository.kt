package com.chatandpay.ws.chat.repository

import com.chatandpay.ws.chat.entity.GroupChatMessage
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface ChatGroupMessageRepository: MongoRepository<GroupChatMessage, UUID>  {
}