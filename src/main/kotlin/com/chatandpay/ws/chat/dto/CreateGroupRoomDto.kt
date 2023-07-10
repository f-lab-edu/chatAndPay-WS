package com.chatandpay.ws.chat.dto

import com.chatandpay.ws.chat.entity.ChatRoom
import org.springframework.validation.annotation.Validated
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull


@Validated
data class CreateGroupChatRoomDto(
    @field:NotBlank(message = "Name cannot be blank")
    val name: String,

    @field:NotNull(message = "Type cannot be null")
    val type: ChatRoom.Type,

    @field:NotNull(message = "Type cannot be null")
    val chatUserIds: List<Long>
)
//
data class UserChatRoomDto(
    val chatUserId: Long,
    val chatRoomId: Long,
)

