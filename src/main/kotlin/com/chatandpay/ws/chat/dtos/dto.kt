package com.chatandpay.ws.chat.controller

import com.chatandpay.ws.chat.entity.ChatRoom
import com.chatandpay.ws.utils.toEpochMillis
import java.time.LocalDateTime
import java.util.UUID

data class ChatRoomDto(
    val id: UUID
)

data class ChatDto(
    val type: Type,
    val sender: String,
    val message: String
) {

    val createdAt: Long = LocalDateTime.now().toEpochMillis()

    enum class Type {
        ENTER, COMMENT
    }
}


internal fun ChatRoom.toDto() = ChatRoomDto(
    id = id
)
