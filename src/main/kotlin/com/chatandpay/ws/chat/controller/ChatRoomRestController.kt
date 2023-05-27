package com.chatandpay.ws.chat.controller

import com.chatandpay.ws.chat.entity.ChatRoom
import org.springframework.http.MediaType
import org.springframework.messaging.handler.annotation.DestinationVariable
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.web.bind.annotation.*
import com.chatandpay.ws.chat.service.ChatRoomService
import java.util.UUID


@RestController
class ChatRoomRestController(
    private val chatRoomService: ChatRoomService
) {

    /**
     * 클라이언트의 /pub 요청을 받아 /sub 에게 보낸다
     * 실제론 해당 블록 내에 채팅 기록 저장 등의 로직이 필요하다
     */
    @MessageMapping("/pub/chat/room/{roomId}")
    @SendTo("/sub/chat/room/{roomId}")
    fun message(@DestinationVariable roomId: String, dto: ChatDto): ChatDto {
        println(roomId);
        return dto
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
