package com.chatandpay.ws.chat.entity

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.UUID


@Document("chatRoom")
data class ChatRoom(
    @Id
    val id: ObjectId = ObjectId(),
    val name: String,
    val type: Type
) {
    enum class Type {
        GROUP, ONE_TO_ONE
    }

}


//data class ChatRoom(
//    val name: String
//) {
//    val id: String
//        get() = "room_$name"
//}
