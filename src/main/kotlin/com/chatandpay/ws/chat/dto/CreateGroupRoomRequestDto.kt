package com.chatandpay.ws.chat.dto

import com.chatandpay.ws.chat.entity.ChatRoom
import org.bson.types.ObjectId
import org.springframework.validation.annotation.Validated
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull


@Validated
data class CreateGroupRoomRequestDto(
    @field:NotBlank(message = "Name cannot be blank")
    val name: String,

    @field:NotNull(message = "Type cannot be null")
    val type: ChatRoom.Type,

    @field:NotNull(message = "Type cannot be null")
    val members: List<ObjectId>
){

}

