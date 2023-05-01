package com.chatandpay.ws

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WsApplication

fun main(args: Array<String>) {
	runApplication<WsApplication>(*args)
}
