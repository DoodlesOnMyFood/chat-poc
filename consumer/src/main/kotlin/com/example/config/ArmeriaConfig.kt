package com.example.config

import com.example.service.ChatHandler
import com.example.service.MessageService
import com.linecorp.armeria.common.HttpRequest
import com.linecorp.armeria.common.HttpResponse
import com.linecorp.armeria.server.HttpService
import com.linecorp.armeria.server.ServiceRequestContext
import com.linecorp.armeria.server.SimpleDecoratingHttpService
import com.linecorp.armeria.server.docs.DocService
import com.linecorp.armeria.server.grpc.GrpcService
import com.linecorp.armeria.spring.ArmeriaServerConfigurator
import io.grpc.Status
import io.grpc.StatusRuntimeException
import mu.KLogging
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.Duration

@Configuration
class ArmeriaConfig {
    companion object : KLogging()

    @Bean
    fun armeriaServerConfig(chatHandler: ChatHandler) = ArmeriaServerConfigurator { builder ->
        builder.requestTimeout(Duration.ofHours(2))
        builder.serviceUnder("/docs", DocService())
        builder.service(
            GrpcService.builder().addService(MessageService(chatHandler)).build(),
            { service: HttpService ->
                object : SimpleDecoratingHttpService(service) {
                    override fun serve(ctx: ServiceRequestContext, req: HttpRequest): HttpResponse {
                        return service.serve(ctx, req).recover { cause ->
                            if (cause is StatusRuntimeException && cause.status.code == Status.Code.CANCELLED) {
                                logger.info { "Cancelled" }
                                HttpResponse.builder().status(200).build()
                            } else {
                                logger.info { "WTF?" }
                                HttpResponse.builder().status(500).build()
                            }
                        }
                    }
                }
            },
        )
    }
}
