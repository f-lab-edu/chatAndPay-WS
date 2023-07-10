package com.chatandpay.ws.chat.controller

import com.chatandpay.ws.chat.dto.ChatMessageDto
import com.chatandpay.ws.chat.entity.PrivateChatMessage
import com.chatandpay.ws.chat.service.ChatMessageService

import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller


@Controller
class PrivateChatController(
    private val chatMessageService: ChatMessageService
) {

    // 클라이언트의 /pub 요청을 받아 /sub 에게 보낸다
    @MessageMapping("/pub/chat/room/{roomId}")
    @SendTo("/sub/chat/room/{roomId}")
    fun message(@DestinationVariable roomId: String,  chatMessageDto: ChatMessageDto): List<PrivateChatMessage> {

        // 사용자가 접속할때마다 채팅 내역을 보여준다
        if(chatMessageDto.type == ChatMessageDto.Type.ENTER) {
            println("접속");
            return chatMessageService.getChatMessagesBySenderId(chatMessageDto);
        }
        // 🔴 메시지 저장 - 보통 이부분은 비동기적으로 처리되지 않을까? 유저가 입력한 메시지를 보여주는게 우선이고 저장이 후순위일 것 같다.
        chatMessageService.savePrivateChatMessage(chatMessageDto);
        return chatMessageService.getChatMessage(chatMessageDto);
    }

}