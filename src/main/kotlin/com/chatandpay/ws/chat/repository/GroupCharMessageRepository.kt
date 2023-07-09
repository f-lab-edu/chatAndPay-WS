package com.chatandpay.ws.chat.repository

import com.chatandpay.ws.chat.entity.GroupChatMessage
import org.springframework.data.jpa.repository.JpaRepository

interface GroupChatMessageRepository: JpaRepository<GroupChatMessage, Long> {
}
