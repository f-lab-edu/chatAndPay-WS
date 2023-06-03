package com.chatandpay.ws.chat.dto

import org.bson.types.ObjectId

data class GroupChatMesageDto(
    val groupId: ObjectId,
    val senderId: ObjectId,
    val message: String
)