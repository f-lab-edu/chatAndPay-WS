package com.chatandpay.ws.chat.controller

import com.chatandpay.ws.chat.entity.ChatMessage
import com.chatandpay.ws.chat.entity.ChatRoom
import com.chatandpay.ws.chat.service.ChatMessageService
import org.springframework.http.MediaType
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.web.bind.annotation.*
import com.chatandpay.ws.chat.service.ChatRoomService
import java.util.UUID


@RestController
class ChatRoomRestController(
    private val chatRoomService: ChatRoomService,
    private val chatMessageService: ChatMessageService
) {

    /**
     * 클라이언트의 /pub 요청을 받아 /sub 에게 보낸다
     * 실제론 해당 블록 내에 채팅 기록 저장 등의 로직이 필요하다
     */
    @MessageMapping("/pub/chat/room/{roomId}")
    @SendTo("/sub/chat/room/{roomId}")
    fun message(@DestinationVariable roomId: String, chatMessageDto: ChatMessageDto): Any? {

        // 사용자가 접속할때마다 채팅 내역을 보여준다
        if(chatMessageDto.type == ChatMessageDto.Type.ENTER){
            println("접속");
//            return chatMessageService.getChatMessagesBySenderId(chatMessageDto);
            val fakeChatMessageDto = ChatMessageDto(
                type = ChatMessageDto.Type.ENTER,
                senderName = "John",
                recieverName = "Alice",
                message = "입장했습니다."
            )
            return fakeChatMessageDto
        }
        // 🔴 메시지 저장 - 보통 이부분은 비동기적으로 처리되지 않을까? 유저가 입력한 메시지를 보여주는게 우선이고 저장이 후순위일 것 같다.
        chatMessageService.saveMessage(chatMessageDto);
        return chatMessageDto;
    }


    //체팅방 생성
    @PostMapping(
        value = ["/api/v1/chat/room"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createRoom(@RequestParam name: String): ChatRoom {
        return chatRoomService.createRoom(name);
    }

     //채팅방 전체 조회
    @GetMapping(
        value = ["/api/v1/chat/room"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findAllRoom(): List<ChatRoom> {
        return chatRoomService.findAllRoom();
    }

    /**
     * 채팅방 정보 조회
     */
    @GetMapping(
        value = ["/api/v1/chat/room/{roomId}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun roomInfo(
        @PathVariable roomId: UUID
    ): ChatRoom? {
        return chatRoomService.findById(roomId)
    }
}
