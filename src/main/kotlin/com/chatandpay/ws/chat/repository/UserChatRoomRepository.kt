package com.chatandpay.ws.chat.repository

import com.chatandpay.ws.chat.dto.UserChatRoomDto
import com.chatandpay.ws.chat.entity.UserChatRoom
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.jdbc.core.BatchPreparedStatementSetter
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.sql.PreparedStatement


interface UserChatRoomRepository : JpaRepository<UserChatRoom, Long> {
}


@Repository
class UserChatRoomInBulkRepository(private val jdbcTemplate: JdbcTemplate) {
    fun saveAll(userChatRoomList: List<UserChatRoom>) {
        jdbcTemplate.batchUpdate("INSERT INTO UserChatRoom(chatUserId, chatRoomId) values (?, ?)",
            object : BatchPreparedStatementSetter {
                override fun setValues(ps: PreparedStatement, i: Int) {
                    ps.setLong(1, userChatRoomList[i].chatUserId!!)
                    ps.setLong(2, userChatRoomList[i].chatRoomId!!)
                }

                override fun getBatchSize(): Int {
                    return userChatRoomList.size
                }
            }
        )
    }
}