package com.chatandpay.ws.chat.controller

import com.chatandpay.ws.chat.dto.ChatRoomDto
import com.chatandpay.ws.chat.dto.CreateGroupRoomRequestDto
import com.chatandpay.ws.chat.dto.CreateRoomRequest
import com.chatandpay.ws.chat.entity.ChatRoom
import com.chatandpay.ws.chat.entity.GroupUser
import com.chatandpay.ws.chat.service.ChatGroupService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import com.chatandpay.ws.chat.service.ChatRoomService
import org.bson.types.ObjectId
import java.util.UUID


@RestController
class ChatRoomRestController(
    private val chatRoomService: ChatRoomService,
    private val chatGroupService: ChatGroupService
) {

    // 체팅방 생성 - 채팅방의 타입 구분
    @PostMapping(
        value = ["/api/v1/chat/room"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createRoom(@RequestBody chatRoomDto: CreateRoomRequest): ChatRoom {
        return chatRoomService.createRoom(chatRoomDto);
    }


    // 그룹 채팅방 생성
    @PostMapping(
        value = ["/api/v1/chat/room/type/group"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createGroupRoom(@RequestBody groupChatRoomDto: CreateGroupRoomRequestDto): ChatRoomDto {
        println(groupChatRoomDto);
        return chatRoomService.createGroupMember(groupChatRoomDto);
    }


    //채팅방 전체 조회
    @GetMapping(
        value = ["/api/v1/chat/room"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findAllRoom(): List<ChatRoomDto>? {
        return chatRoomService.findAllRoom();
    }

    // 채팅방 조회
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
