package com.example.service

import com.example.chat.ChatMessage
import com.example.chat.ChatServiceGrpc
import io.grpc.Status
import io.grpc.stub.StreamObserver
import mu.KLogging

class MessageService(private val chatHandler: ChatHandler) : ChatServiceGrpc.ChatServiceImplBase() {
    companion object : KLogging()
    override fun chat(responseObserver: StreamObserver<ChatMessage>): StreamObserver<ChatMessage> {
        var close: (() -> Unit)? = null
        return object : StreamObserver<ChatMessage> {
            override fun onNext(value: ChatMessage) {
                if (close == null) {
                    close = chatHandler.initConnection(value, responseObserver)
                }
                chatHandler.consumeMessage(value)
            }

            override fun onError(t: Throwable) {
                if (t is io.grpc.StatusRuntimeException && t.status.code == Status.Code.CANCELLED) {
                    logger.info { "Connection Canceled" }
                }
            }

            override fun onCompleted() {
                close?.invoke()
            }
        }
    }
}
