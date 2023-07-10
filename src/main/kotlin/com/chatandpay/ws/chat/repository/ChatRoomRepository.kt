package com.chatandpay.ws.chat.repository

import com.chatandpay.ws.chat.entity.ChatRoom
import com.chatandpay.ws.chat.entity.UserChatRoom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.jdbc.core.BatchPreparedStatementSetter
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.PreparedStatement
import java.sql.SQLException


interface ChatRoomRepository : JpaRepository<ChatRoom, Long> {
}





