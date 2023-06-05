package com.chatandpay.ws.chat.service

import com.chatandpay.ws.chat.dto.ChatRoomDto
import com.chatandpay.ws.chat.dto.CreateGroupRoomDto
import com.chatandpay.ws.chat.dto.CreateRoomRequest
import org.springframework.stereotype.Service
import com.chatandpay.ws.chat.entity.ChatRoom
import com.chatandpay.ws.chat.entity.GroupUser
import com.chatandpay.ws.chat.entity.toDto
import com.chatandpay.ws.chat.repository.ChatRoomRepository
import com.chatandpay.ws.chat.repository.GroupUserRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.*

@Service
class ChatRoomService(
    private val chatRoomRepository: ChatRoomRepository,
    private val groupUserRepository: GroupUserRepository
) {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    class ChatRoomCreationException(message: String, cause: Throwable) : RuntimeException(message, cause)

    fun findAllRoom(): List<ChatRoomDto>? {
        val chatRoom = chatRoomRepository.findAll();
        return chatRoom?.map { it.toDto() }
    }
    fun findById(id: UUID): ChatRoom? {
        val optionalChatRoom: Optional<ChatRoom> = chatRoomRepository.findById(id)
        println(optionalChatRoom)
        return optionalChatRoom.orElse(null)
    }

    fun createRoom(chatRoomDto: CreateRoomRequest): ChatRoom {
        try {
            val chatRoom = ChatRoom(
                name = chatRoomDto.name,
                type = chatRoomDto.type
            )
            return chatRoomRepository.save(chatRoom)
        } catch (e: Exception) { e.printStackTrace()
            throw ChatRoomCreationException("Failed to create chat room : ", e)
        }
    }

    // 그룹 유저 저장
    fun createGroupMember(groupChatRoomDto: CreateGroupRoomDto): ChatRoomDto{

        try {
            // 🔴 이부분은 어떻게 처리 되어야 하는지? 트랜잭션으로 처리해야할지?
            val groupChatRoom = ChatRoom(
                name = groupChatRoomDto.name,
                type = groupChatRoomDto.type
            )
            val chatRoom = chatRoomRepository.save(groupChatRoom);

            println(chatRoom.id);

            val groupUsers = groupChatRoomDto.members.map{userId ->
                GroupUser(groupId = chatRoom.id, userId = userId);
            }

            groupUserRepository.saveAll(groupUsers);

            return ChatRoomDto(
                id = chatRoom.id.toString(),
                name = chatRoom.name,
                type = chatRoom.type
            )

        } catch (e: Exception) { e.printStackTrace()
            throw ChatRoomService.ChatRoomCreationException("Failed to save group users", e)
        }
    }

}
