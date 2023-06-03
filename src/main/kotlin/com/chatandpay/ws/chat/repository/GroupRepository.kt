package com.chatandpay.ws.chat.repository

import com.chatandpay.ws.chat.entity.ChatMessage
import com.chatandpay.ws.chat.entity.Group
import com.chatandpay.ws.chat.entity.GroupUser
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface GroupUserRepository : MongoRepository<GroupUser, UUID> {
}