package com.chatandpay.ws.chat.repository

import com.chatandpay.ws.chat.entity.PrivateChatMessage
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*


interface PrivateChatMessageRepository : JpaRepository<PrivateChatMessage, Long> {
    fun findBySenderId(senderId: Long): List<PrivateChatMessage>
}