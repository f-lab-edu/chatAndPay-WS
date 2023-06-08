package com.chatandpay.ws.chat.entity

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document("groupMembers")
data class GroupUser (
    // groupId,userId 복합키로 사용
    val groupId: ObjectId,
    val userId: ObjectId,
){
}