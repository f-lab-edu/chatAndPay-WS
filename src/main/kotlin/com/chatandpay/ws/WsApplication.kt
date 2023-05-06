package com.chatandpay.ws

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam

@SpringBootApplication
class WsApplication

fun main(args: Array<String>) {
	runApplication<WsApplication>(*args)
}

@RestController
class MessageController {
	@GetMapping("/")
	fun index() = listOf(
		Message("1", "Hello!"),
		Message("2", "Bonjour!"),
		Message("3", "Hola!"),
	)

	data class Message(val id: String?, val text: String)
}

