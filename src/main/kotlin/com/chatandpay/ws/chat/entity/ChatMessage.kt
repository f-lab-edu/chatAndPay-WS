package com.chatandpay.ws.chat.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.util.UUID


@Document(collection = "chatMessage")
data class ChatMessage(
    val message: String,
    @Field("sender_id")
    val senderId: UUID,
    @Field("receiver_id")
    val receiverId: UUID,
    val createdAt: Long
) {
    @Id
    var id: UUID = UUID.randomUUID()
}