package com.chatandpay.ws.chat.view

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam


@Controller
class ChatRoomController {

    @GetMapping("/chat/room")
    fun room(model: Model): String {
        return "/chat/room"
    }

    @GetMapping("/chat/room/{roomId}")
    fun roomEnter(
        model: Model,
        @PathVariable roomId: String?,
        @RequestParam(required = true) type: String
    ): String {
        model.addAttribute("roomId", roomId)
        model.addAttribute("type", type)
        return "/chat/roomdetail"
    }
}
