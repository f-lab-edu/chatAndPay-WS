package com.chatandpay.ws.chat.controller

import com.chatandpay.ws.chat.dto.GroupChatMessageDto
import com.chatandpay.ws.chat.entity.GroupChatMessage
import com.chatandpay.ws.chat.service.ChatMessageService
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class GroupChatController(
    private val chatMessageService: ChatMessageService
) {

    // 그룹 메시지
    @MessageMapping("/pub/chat/room/{chatRoomId}/type/group")
    @SendTo("/sub/chat/room/{chatRoomId}/type/group")
    fun groupMessage(@DestinationVariable chatRoomId: Long,groupChatMessage: GroupChatMessageDto):List<GroupChatMessage> {
        println("그룹채팅 접속")
        return chatMessageService.saveGroupMessage(chatRoomId,groupChatMessage);
    }
}