package com.chatandpay.ws.chat.repository

import com.chatandpay.ws.chat.entity.ChatGroupMessage
import com.chatandpay.ws.chat.entity.ChatMessage
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface ChatGroupMessageRepository: MongoRepository<ChatGroupMessage, UUID>  {
}