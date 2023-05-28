package com.chatandpay.ws.chat.entity

import com.chatandpay.ws.chat.controller.ChatMessageDto
import com.chatandpay.ws.utils.toEpochMillis
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.data.mongodb.core.mapping.FieldType
import java.time.LocalDateTime
import java.util.Date
import java.util.UUID


@Document(collection = "chatMessage")
data class ChatMessage(
    val message: String,
    val senderId: UUID,
    val recieverId: UUID,
    val createdAt: Long
) {
    @Id
    var id: UUID = UUID.randomUUID()
}