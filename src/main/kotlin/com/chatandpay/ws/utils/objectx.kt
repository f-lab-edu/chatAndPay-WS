package com.chatandpay.ws.utils

import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset


@Suppress("UNCHECKED_CAST")
fun <T> lateInit(): T = null as T

inline fun <T : Any> T?.notNull(lazyMessage: () -> Any): T = requireNotNull(this, lazyMessage)

fun LocalDateTime.toEpochMillis(zoneId: ZoneId = ZoneOffset.UTC): Long = this.atZone(zoneId).toInstant().toEpochMilli()
