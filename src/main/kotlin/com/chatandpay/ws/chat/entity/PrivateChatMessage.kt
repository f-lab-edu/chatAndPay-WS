package com.chatandpay.ws.chat.entity

import com.chatandpay.ws.chat.dto.ChatMessageDto
import com.chatandpay.ws.utils.toEpochMillis
import java.time.LocalDateTime
import javax.persistence.*


@Entity
@Table(name = "PrivateChatMessage")
data class PrivateChatMessage(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    var message: String,

    val senderName: String,

    var senderId: Long,

    var receiverId: Long,

    val receiverName: String?,

    var createdAt: Long = LocalDateTime.now().toEpochMillis()
){
    companion object {
        @JvmStatic
        fun create(chatMessageDto: ChatMessageDto): PrivateChatMessage {
            val currentTime = chatMessageDto.createdAt
            return PrivateChatMessage(
                message = chatMessageDto.message,
                senderId = chatMessageDto.senderId,
                senderName = chatMessageDto.senderName,
                receiverId = chatMessageDto.receiverId,
                receiverName = chatMessageDto.receiverName,
                createdAt = currentTime
            )
        }

        @JvmStatic
        fun createEnterMessage(chatMessageDto: ChatMessageDto): PrivateChatMessage {
            return PrivateChatMessage(
                senderName = chatMessageDto.senderName,
                senderId = chatMessageDto.senderId,
                message = "${chatMessageDto.senderName}님이 입장했습니다.",
                receiverId = chatMessageDto.receiverId,
                receiverName = chatMessageDto.receiverName,
            )
        }

    }


}

