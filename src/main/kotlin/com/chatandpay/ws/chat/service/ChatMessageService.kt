package com.chatandpay.ws.chat.service

import com.chatandpay.ws.chat.controller.ChatMessageDto
import com.chatandpay.ws.chat.entity.ChatMessage
import com.chatandpay.ws.chat.repository.ChatMessageRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ChatMessageService (
    private val chatMessageRepository: ChatMessageRepository
    ){

    fun saveMessage(chatMessageDto: ChatMessageDto): Unit {
        println(chatMessageDto);
        if(chatMessageDto.type == ChatMessageDto.Type.COMMENT){
            val chatMessage = ChatMessage(
                message = chatMessageDto.message,
                senderId = chatMessageDto.senderId,
                recieverId = chatMessageDto.recieverId,
                createdAt = chatMessageDto.createdAt
            )
            chatMessageRepository.save(chatMessage);
        }
    }

    fun getChatMessagesBySenderId(chatMessageDto: ChatMessageDto):List<ChatMessage>? {

        // 채팅방의 모든 채팅 기록 조회
        val allChatMessages = chatMessageRepository.findAllBySenderIdOrderByCreatedAtAsc(UUID.fromString("675d474d-bb6c-453d-a1ac-f1c59825cfe1"));
        if (allChatMessages.isNotEmpty()) {
            return allChatMessages;
        }

        return null;

    }

}