//package com.chatandpay.ws.chat.dto
//
//import com.chatandpay.ws.utils.toEpochMillis
//import org.bson.types.ObjectId
//import java.time.LocalDateTime
//
//data class GroupChatMesageRequestDto(
//    val type: Type,
//    val senderId: ObjectId = ObjectId(), // 유저가 생기면 바궈야함
//    val senderName: String,
//    val message: String
//){
//    val createdAt: Long = LocalDateTime.now().toEpochMillis()
//    enum class Type {
//        ENTER, COMMENT
//    }
//}
//
//
//data class GroupChatMesageResponseDto(
//    val id: String?,
//    val senderId: String,
//    val senderName: String,
//    val message: String,
//    val createdAt: Long
//)