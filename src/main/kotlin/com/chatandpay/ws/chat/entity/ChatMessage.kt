package com.chatandpay.ws.chat.entity

import com.chatandpay.ws.utils.toEpochMillis
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime
import java.util.UUID


@Document(collection = "chatMessage")
data class ChatMessage(
    val message: String,
    @Field("sender_id")
    val senderId: ObjectId,
    @Field("receiver_id")
    val receiverId: ObjectId
) {
    val createdAt: Long = LocalDateTime.now().toEpochMillis()
}