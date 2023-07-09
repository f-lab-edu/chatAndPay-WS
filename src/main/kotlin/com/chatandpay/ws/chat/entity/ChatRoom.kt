package com.chatandpay.ws.chat.entity


import javax.persistence.*

@Entity(name = "ChatRoom")
data class ChatRoom(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id: Long? = null,

    @Column(name = "name", nullable = false)
    var name: String,

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    var type: Type,

    @Column(name = "createdAt", nullable = false)
    var createdAt: Long = System.currentTimeMillis()
) {
    enum class Type {
        GROUP, PRIVATE
    }

    companion object {
        @JvmStatic
        fun create(name: String, type: Type): ChatRoom {
            return ChatRoom(name = name, type = type)
        }
    }

}




//data class ChatRoom(
//    val name: String
//) {
//    val id: String
//        get() = "room_$name"
//}
