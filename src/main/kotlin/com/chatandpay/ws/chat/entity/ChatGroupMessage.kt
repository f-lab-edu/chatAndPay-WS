package com.chatandpay.ws.chat.entity

import com.chatandpay.ws.utils.toEpochMillis
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime
import java.util.*


@Document(collection = "groupMessage")
data class ChatGroupMessage(
    @Field("group_id")
    val groupId: UUID,
    @Field("sender_id")
    val senderId: UUID,
    val message: String,

) {
    val createdAt: Long = LocalDateTime.now().toEpochMillis()
    @Id
    var id: UUID = UUID.randomUUID()
}
