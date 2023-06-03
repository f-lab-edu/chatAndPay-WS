package com.chatandpay.ws.chat.entity

import com.chatandpay.ws.utils.toEpochMillis
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import java.time.LocalDateTime
import java.util.*


@Document(collection = "groupMessage")
data class GroupChatMessage(
    @Field("group_id")
    val groupId: ObjectId,
    @Field("sender_id")
    val senderId: ObjectId,
    val message: String,

) {
    val createdAt: Long = LocalDateTime.now().toEpochMillis()
    @Id
    var id: ObjectId = ObjectId()
}
