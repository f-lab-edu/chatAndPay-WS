package com.chatandpay.ws.chat.entity

import com.chatandpay.ws.utils.toEpochMillis
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime
import java.util.UUID


@Document(collection = "chatMessage")
data class ChatMessage(
    val message: String,
    @Field("sender_id")
    val senderId: UUID,
    @Field("receiver_id")
    val receiverId: UUID
) {
    @Id
    var id: UUID = UUID.randomUUID()
    val createdAt: Long = LocalDateTime.now().toEpochMillis()
}