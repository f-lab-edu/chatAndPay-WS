//package com.chatandpay.ws.chat.entity
//
//import org.springframework.data.annotation.Id
//import java.util.*
//
//abstract class UuidIdentifiedEntity {
//    @Id
//    protected var id: UUID? = null
//
//    @JvmName("setUuid")
//    fun setId(customId: UUID?) {
//        if (this.id != null) {
//            throw UnsupportedOperationException("ID is already defined")
//        }
//        this.id = customId
//    }
//
//
//}
