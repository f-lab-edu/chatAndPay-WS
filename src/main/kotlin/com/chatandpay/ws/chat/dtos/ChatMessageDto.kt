package com.chatandpay.ws.chat.dtos

import com.chatandpay.ws.utils.toEpochMillis
import java.time.LocalDateTime
import java.util.UUID


data class ChatMessageDto(
    val type: Type,
    val senderName: String,
    val senderId: UUID = UUID.randomUUID(),
    val recieverId: UUID = UUID.randomUUID(),
    val recieverName: String?, // 애도 비어있으면 안되지만 일단은..
    val message: String,
    val createdAt: Long
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




