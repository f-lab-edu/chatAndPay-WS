package com.chatandpay.ws.chat.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "group")
data class Group(
    @Id
    var id: UUID = UUID.randomUUID()
)
