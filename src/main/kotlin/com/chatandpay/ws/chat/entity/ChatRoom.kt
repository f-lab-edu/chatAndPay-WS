package com.chatandpay.ws.chat.entity

import com.chatandpay.ws.chat.dto.ChatRoomDto
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

// ChatRoom 확장 함수
fun ChatRoom.toDto() = ChatRoomDto(
    id = this.id.toString(),
    name = this.name,
    type = this.type
)



//data class ChatRoom(
//    val name: String
//) {
//    val id: String
//        get() = "room_$name"
//}
