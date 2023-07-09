//package com.chatandpay.ws.chat.repository
//
//import com.chatandpay.ws.chat.entity.ChatMessage
//import org.springframework.data.mongodb.repository.MongoRepository
//import org.springframework.data.mongodb.repository.Query
//import java.util.*
//
//
//interface ChatMessageRepository : MongoRepository<ChatMessage, UUID> {
//    fun findAllBySenderIdOrderByCreatedAtAsc(senderId: UUID): List<ChatMessage>
//}