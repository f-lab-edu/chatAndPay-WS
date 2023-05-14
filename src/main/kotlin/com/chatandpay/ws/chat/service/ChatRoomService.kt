package com.chatandpay.ws.chat.service

import org.springframework.stereotype.Service
import com.chatandpay.ws.chat.entity.ChatRoom
import com.chatandpay.ws.chat.repository.ChatRoomRepository

@Service
class ChatRoomService(
    private val chatRoomRepository: ChatRoomRepository
) {

    fun findAllRoom(): List<ChatRoom> {
        return chatRoomRepository.findAllRoom()
    }

    fun findById(id: String): ChatRoom {
        return chatRoomRepository.findById(id)
    }

    fun createRoom(name: String): ChatRoom {
        return chatRoomRepository.createRoom(name)
    }
}
