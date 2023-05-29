package com.chatandpay.ws.chat.dtos

import com.chatandpay.ws.chat.entity.ChatRoom
import java.util.*

data class ChatRoomDto(
    val id: UUID
)


internal fun ChatRoom.toDto() = ChatRoomDto(
    id = id
)