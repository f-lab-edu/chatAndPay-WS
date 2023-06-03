package com.chatandpay.ws.chat.controller

import com.chatandpay.ws.chat.dto.ChatMessageDto
import com.chatandpay.ws.chat.dto.GroupChatMesageDto
import com.chatandpay.ws.chat.entity.GroupChatMessage
import com.chatandpay.ws.chat.entity.GroupUser
import com.chatandpay.ws.chat.service.ChatMessageService
import org.bson.types.ObjectId
import org.springframework.http.MediaType
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class ChatMessageRestController(
    private val chatMessageService: ChatMessageService
) {


    /**
     * 클라이언트의 /pub 요청을 받아 /sub 에게 보낸다
     * 실제론 해당 블록 내에 채팅 기록 저장 등의 로직이 필요하다
     */
    @MessageMapping("/pub/chat/room/{roomId}")
    @SendTo("/sub/chat/room/{roomId}")
    fun message(@DestinationVariable roomId: String,  chatMessageDto: ChatMessageDto): List<ChatMessageDto> {

        // 사용자가 접속할때마다 채팅 내역을 보여준다
        if(chatMessageDto.type == ChatMessageDto.Type.ENTER) {
            println("접속");
            return chatMessageService.getChatMessagesBySenderId(chatMessageDto);
        }
        // 🔴 메시지 저장 - 보통 이부분은 비동기적으로 처리되지 않을까? 유저가 입력한 메시지를 보여주는게 우선이고 저장이 후순위일 것 같다.
        chatMessageService.saveMessage(chatMessageDto);
        return listOf(chatMessageDto);
    }


    // 그룹 메시지
    @MessageMapping("/pub/chat/group/{groupId}")
    @SendTo("/sub/chat/group/{groupId}")
    fun groupMessage(@DestinationVariable groupId: ObjectId, groupChatMessage:GroupChatMesageDto): GroupChatMessage {
        return chatMessageService.createGroupMessage(groupId,groupChatMessage);
    }

}