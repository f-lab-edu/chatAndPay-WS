package com.chatandpay.ws.chat.repository

import com.chatandpay.ws.chat.entity.ChatRoom
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.UUID

interface ChatRoomRepository : MongoRepository<ChatRoom, UUID> {
}