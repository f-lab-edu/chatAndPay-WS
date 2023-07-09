package com.chatandpay.ws.chat.dto


import java.time.LocalDateTime
import java.util.UUID

data class ChatMessageDto(
    val type: Type,
    val senderName: String,
    val senderId: UUID = UUID.randomUUID(),
    val receiverId:  UUID = UUID.randomUUID(),
    val receiverName: String? = null,
    val message: String,
    val createdAt: Long = LocalDateTime.now().toEpochMilli()
) {
    enum class Type {
        ENTER, COMMENT
    }
}


data class EnterMessageDto(
    val senderName:String,
    val recieverName:String,
    val message:String="입장했습니다"
)




