package com.chatandpay.ws.chat.service


import com.chatandpay.ws.chat.dto.ChatMessageDto
import com.chatandpay.ws.chat.dto.GroupChatMessageDto
import com.chatandpay.ws.chat.entity.GroupChatMessage
import com.chatandpay.ws.chat.entity.PrivateChatMessage
import com.chatandpay.ws.chat.repository.GroupChatMessageRepository
import com.chatandpay.ws.chat.repository.PrivateChatMessageRepository
import org.springframework.stereotype.Service

@Service
class ChatMessageService (
    private val privateChatMessageRepository: PrivateChatMessageRepository,
    private val groupChatMessageRepository:GroupChatMessageRepository
    ){

    fun savePrivateChatMessage(chatMessageDto: ChatMessageDto) {
        val chatMessage = PrivateChatMessage.create(chatMessageDto)
        privateChatMessageRepository.save(chatMessage)
    }

    fun getChatMessagesBySenderId(chatMessageDto: ChatMessageDto):List<PrivateChatMessage> {

        // 채팅방의 모든 채팅 기록 조회 -**********
        val chatMessages = privateChatMessageRepository.findBySenderId(chatMessageDto.senderId)
        // 나중에 현재 유저의 아이디 값으로 변경할 것

        println(chatMessages);
        if (chatMessages.isNotEmpty()) { // 이렇게 맵을 써서 처리하는 방식에 대해 물어보기, 전개연산자
            return chatMessages.map {chatMessage -> PrivateChatMessage.create(chatMessageDto)
            } // 🔴 전개연산자를 사용할 수 없는가? -> 그냥 객체 던짐
        }

        // 채팅방 기록이 없다면 최초 입장으로 파악 -> 입장했습니다 메시지 반환
        return listOf(PrivateChatMessage.createEnterMessage(chatMessageDto))

    }


    fun getChatMessage(chatMessageDto: ChatMessageDto):List<PrivateChatMessage>  {
        return listOf(PrivateChatMessage.create(chatMessageDto))
    }


    fun saveGroupMessage(chatRoomId:Long,groupChatMessageDto: GroupChatMessageDto):List<GroupChatMessage> {
        try {
            val groupChatMessage = GroupChatMessage.create(chatRoomId,groupChatMessageDto);
            return listOf(groupChatMessageRepository.save(groupChatMessage));
        } catch (e: Exception) { e.printStackTrace()
            throw ChatRoomService.ChatRoomCreationException("Failed to create chat room", e)
        }
    }

}