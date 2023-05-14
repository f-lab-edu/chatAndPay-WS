package com.chatandpay.ws.chat.repository

import org.springframework.stereotype.Repository
import com.chatandpay.ws.chat.entity.ChatRoom

@Repository
class ChatRoomRepository {

    private val chatRooms = LinkedHashMap<String, ChatRoom>()

    fun findAllRoom(): List<ChatRoom> {
        return chatRooms.values.toList()
    }

    fun findById(id: String): ChatRoom {
        return chatRooms[id]!!
    }

    fun createRoom(name: String): ChatRoom {
        return ChatRoom(
            name = name
        ).also {
            chatRooms[it.id] = it
        }
    }
}
