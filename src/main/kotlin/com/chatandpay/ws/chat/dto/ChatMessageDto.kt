package com.chatandpay.ws.chat.dto


import com.chatandpay.ws.utils.toEpochMillis
import java.time.LocalDateTime
import java.util.UUID

data class ChatMessageDto(
    val type: Type,
    val senderName: String,
    val senderId: Long,
    val receiverId:  Long,
    val receiverName: String?,
    val message: String,
    val createdAt: Long = LocalDateTime.now().toEpochMillis()
) {
    enum class Type {
        ENTER, COMMENT
    }
}





