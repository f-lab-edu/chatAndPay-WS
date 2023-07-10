package com.chatandpay.ws.chat.entity

import com.chatandpay.ws.utils.toEpochMillis
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "UserChatRoom")
class UserChatRoom(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    val chatUserId: Long?,

    val chatRoomId: Long?,

    val createdAt: Long = LocalDateTime.now().toEpochMillis()
){
    companion object {
        @JvmStatic
        fun create(chatRoomId: Long?, chatUserId: Long?): UserChatRoom {
            return UserChatRoom(chatRoomId = chatRoomId, chatUserId = chatUserId)
        }
    }

}
