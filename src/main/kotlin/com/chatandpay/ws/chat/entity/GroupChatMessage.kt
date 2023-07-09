//package com.chatandpay.ws.chat.entity
//
//import com.chatandpay.ws.chat.dto.GroupChatMesageResponseDto
//import org.springframework.data.annotation.Id
//import javax.persistence.*
//
//
//@Entity
//data class GroupChatMessage(
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    var id: Long? = null,
//
//    var groupId: Long,
//
//    var senderId: Long,
//
//    var senderName: String,
//
//    var message: String,
//
//    var createdAt: Long = System.currentTimeMillis()
//)
//
//
//
//
//fun GroupChatMessage.toDto() = GroupChatMesageResponseDto(
//    id = this.id.toString(),
//    senderId = this.senderId.toString(),
//    senderName = this.senderName,
//    message = this.message,
//    createdAt = this.createdAt
//)
