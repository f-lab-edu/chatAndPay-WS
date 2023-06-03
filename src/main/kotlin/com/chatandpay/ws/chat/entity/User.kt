package com.chatandpay.ws.chat.entity

import java.util.UUID

data class User (
    val password: String,
    val status: String, // 접속 상태는 자주 상태가 바뀔텐데 어떻게 처리해야하는가? 캐시로 처리하겠지만...
    val phone: String
        ){
    val id: UUID = UUID.randomUUID()
}