package com.example.service

import com.example.chat.ChatMessage
import com.example.repo.ChatRoomRepo
import io.grpc.stub.StreamObserver
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.future.asDeferred
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import java.util.concurrent.ConcurrentHashMap

@Service
class ChatHandler(
    private val chatRoomRepo: ChatRoomRepo,
    private val kafkaTemplate: KafkaTemplate<String, ChatMessage>
) {
    private val connections = ConcurrentHashMap<String, StreamObserver<ChatMessage>>()

    fun initConnection(message: ChatMessage, responseStream: StreamObserver<ChatMessage>): () -> Unit {
        connections.putIfAbsent(message.user, responseStream)
        return {
            connections.remove(message.user)
        }
    }

    fun consumeMessage(message: ChatMessage) {
        runBlocking {
            kafkaTemplate.send("messages", message.dest, message).asDeferred()
            launch {
                chatRoomRepo.getChatRoomUsers(message.dest)
                    .filter { user -> connections.containsKey(user.id) }
                    .filter { user -> user.id != message.user }
                    .map { user -> connections[user.id] }
                    .map { stream -> stream!!.onNext(message) }
                    .collect()
            }
        }
    }
}
