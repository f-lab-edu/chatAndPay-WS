package com.chatandpay.ws.chat.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.UUID


@Document("chatRoom")
data class ChatRoom(
    val name: String
) {
    @Id
    var id: UUID = UUID.randomUUID()
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
