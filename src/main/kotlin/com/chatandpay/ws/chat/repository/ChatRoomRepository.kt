package com.chatandpay.ws.chat.repository

import com.chatandpay.ws.chat.entity.ChatRoom
import org.springframework.data.jpa.repository.JpaRepository


interface ChatRoomRepository : JpaRepository<ChatRoom, Long> {
}