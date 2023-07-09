package com.chatandpay.ws.chat.dto

import com.chatandpay.ws.utils.toEpochMillis
import java.time.LocalDateTime

data class GroupChatMessageDto(
    val type: Type,
    val senderId: Long, // 유저가 생기면 바궈야함
    val senderName: String,
    val message: String
){
    val createdAt: Long = LocalDateTime.now().toEpochMillis()
    enum class Type {
        ENTER, COMMENT
    }
}


//data class GroupChatMesageResponseDto(
//    val id: String?,
//    val senderId: String,
//    val senderName: String,
//    val message: String,
//    val createdAt: Long
//)