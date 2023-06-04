package com.chatandpay.ws.chat.dto

import com.chatandpay.ws.chat.entity.ChatRoom
import org.springframework.validation.annotation.Validated
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

//data class ChatRoomDto(
//    val id: UUID
//)
//
//
//internal fun ChatRoom.toDto() = ChatRoomDto(
//    id = id
//)


@Validated
data class CreateRoomRequest(
    @field:NotBlank(message = "Name cannot be blank")
    val name: String,

    @field:NotNull(message = "Type cannot be null")
    val type: ChatRoom.Type
)
