package com.chatandpay.ws.chat.dto

import org.bson.types.ObjectId
import java.util.UUID


data class ChatMessageDto(
    val type: Type,
    val senderName: String,
    val senderId: ObjectId = ObjectId(),
    val recieverId: ObjectId = ObjectId(),
    val recieverName: String?, // 애도 비어있으면 안되지만 일단은..
    val message: String
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




