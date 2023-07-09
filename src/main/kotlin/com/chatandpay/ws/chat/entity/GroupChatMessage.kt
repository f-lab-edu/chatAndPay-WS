package com.chatandpay.ws.chat.entity

import com.chatandpay.ws.chat.dto.GroupChatMessageDto
import com.chatandpay.ws.utils.toEpochMillis
import org.springframework.data.annotation.Id
import java.time.LocalDateTime
import javax.persistence.*


@Entity
data class GroupChatMessage(
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    var chatRoomId: Long,

    var senderId: Long,

    var senderName: String,

    var message: String,

    var createdAt: Long = LocalDateTime.now().toEpochMillis()
) {

    companion object {
        @JvmStatic
        fun create(chatRoomId: Long, groupChatMessageDto: GroupChatMessageDto): GroupChatMessage {
            return GroupChatMessage(
                chatRoomId = chatRoomId,
                message = groupChatMessageDto.message,
                senderId = groupChatMessageDto.senderId,
                senderName = groupChatMessageDto.senderName
            )
        }
    }




}