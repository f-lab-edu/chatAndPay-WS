package com.chatandpay.ws.chat.dto

data class ChatRoomQueryDto(
    val page: Int = 0,
    val size: Int = 10,
    val sort: String = "id,asc"
)
