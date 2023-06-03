package com.chatandpay.ws.chat.controller

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

    //체팅방 생성 - 채팅방의 타입
    @PostMapping(
        value = ["/api/v1/chat/room"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createRoom(@RequestParam name: String): ChatRoom {
        return chatRoomService.createRoom(name);
    }


    // 그룹 생성
    @PostMapping(
        value = ["/api/v1/chat/group"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createGroupRoom(@RequestParam members : List<ObjectId>): List<GroupUser> {
        return chatGroupService.createGroupMember(members);
    }


    //채팅방 전체 조회
    @GetMapping(
        value = ["/api/v1/chat/room"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findAllRoom(): List<ChatRoom> {
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
