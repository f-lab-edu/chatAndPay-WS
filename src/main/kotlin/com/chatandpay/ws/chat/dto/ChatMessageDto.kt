package com.chatandpay.ws.chat.dto


import com.chatandpay.ws.utils.toEpochMillis
import org.bson.types.ObjectId
import org.springframework.validation.annotation.Validated
import java.time.LocalDateTime
data class ChatMessageDto (
    val type: Type,
    val senderName: String,
    val senderId: ObjectId = ObjectId(),
    val recieverId: ObjectId = ObjectId(),
    val recieverName: String?, // 애도 비어있으면 안되지만 일단은..
    val message: String
) {
    val createdAt: Long = LocalDateTime.now().toEpochMillis()
    enum class Type {
        ENTER, COMMENT
    }

}


data class EnterMessageDto(
    val senderName:String,
    val recieverName:String,
    val message:String="입장했습니다"
)




