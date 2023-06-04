package com.chatandpay.ws.chat.entity

import org.bson.types.ObjectId

data class UserGroup(
    val userId: ObjectId,
    val groupId: ObjectId
) {
}