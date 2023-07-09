package com.chatandpay.ws.chat.repository

import com.chatandpay.ws.chat.dto.UserChatRoomDto
import com.chatandpay.ws.chat.entity.UserChatRoom
import org.springframework.data.jpa.repository.JpaRepository


interface UserChatRoomRepository : JpaRepository<UserChatRoom, Long> {
}