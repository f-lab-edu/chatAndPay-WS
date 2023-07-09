package com.chatandpay.ws.chat.controller

import com.chatandpay.ws.chat.dto.*
import com.chatandpay.ws.chat.entity.ChatRoom

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import com.chatandpay.ws.chat.service.ChatRoomService
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort


@RestController
class ChatRoomRestController(
    private val chatRoomService: ChatRoomService,
//    private val chatGroupService: ChatGroupService
) {

    // 1:1 채팅방 생성
    @PostMapping(
        value = ["/api/v1/chat/room"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createRoom(@RequestBody chatRoomDto: CreateRoomRequest): ChatRoom {
        println(chatRoomDto);
        return chatRoomService.createPrivateChatRoom(chatRoomDto);
    }


    // 그룹 채팅방 생성
    @PostMapping(
        value = ["/api/v1/chat/room/type/group"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun createGroupRoom(@RequestBody groupChatRoomDto: CreateGroupChatRoomDto): ChatRoom {
        return chatRoomService.createGroupChatRoom(groupChatRoomDto);
    }


    //채팅방 전체 조회
    @GetMapping(
        value = ["/api/v1/chat/room"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun findAllRoom(queryDTO: ChatRoomQueryDTO): List<ChatRoom> {
        val sortProperty = queryDTO.sort.split(",")[0]
        val sortDirection = Sort.Direction.fromString(queryDTO.sort.split(",")[1])
        val pageable: Pageable = PageRequest.of(queryDTO.page, queryDTO.size, Sort.by(sortDirection, sortProperty))
        return chatRoomService.findAllRoom(pageable)
    }

    // 채팅방 조회
    @GetMapping(
        value = ["/api/v1/chat/room/{roomId}"],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun roomInfo(
        @PathVariable roomId: Long
    ): ChatRoom? {
        return chatRoomService.findById(roomId)
    }
}
