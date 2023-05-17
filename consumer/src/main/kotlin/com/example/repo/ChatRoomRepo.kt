package com.example.repo

import com.example.data.tables.pojos.Users
import com.example.data.tables.references.USERS
import com.example.data.tables.references.USER_CHAT_ROOMS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.reactive.asFlow
import org.jooq.DSLContext
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import java.util.UUID

@Repository
class ChatRoomRepo(private val dsl: DSLContext) {
    suspend fun getChatRoomUsers(identifier: String): Flow<Users> {
        val identifier = UUID.fromString(identifier)
        val query = dsl.select(USERS)
            .from(USERS)
            .join(USER_CHAT_ROOMS)
            .on(USERS.ID.eq(USER_CHAT_ROOMS.USER_ID))
            .where(USER_CHAT_ROOMS.CHAT_ROOM_ID.eq(identifier))
        return Flux.from(query)
            .asFlow()
            .map { it.into(Users::class.java) }
    }
}
