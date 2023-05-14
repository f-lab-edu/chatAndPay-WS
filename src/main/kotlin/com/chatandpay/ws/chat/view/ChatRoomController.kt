package com.chatandpay.ws.chat.view

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable


@Controller
class ChatRoomController {

    @GetMapping("/chat/room")
    fun room(model: Model): String {
        return "/chat/room"
    }

    @GetMapping("/chat/room/{roomId}")
    fun roomEnter(
        model: Model,
        @PathVariable roomId: String?
    ): String {
        model.addAttribute("roomId", roomId)
        return "/chat/roomdetail"
    }
}
