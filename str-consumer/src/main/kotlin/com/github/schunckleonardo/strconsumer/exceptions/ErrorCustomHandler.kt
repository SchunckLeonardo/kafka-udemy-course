package com.github.schunckleonardo.strconsumer.exceptions

import org.apache.kafka.clients.consumer.Consumer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.listener.KafkaListenerErrorHandler
import org.springframework.kafka.listener.ListenerExecutionFailedException
import org.springframework.messaging.Message
import org.springframework.stereotype.Component

@Component
class ErrorCustomHandler : KafkaListenerErrorHandler {

    private val logger: Logger = LoggerFactory.getLogger(ErrorCustomHandler::class.java)

    override fun handleError(
        message: Message<*>,
        exception: ListenerExecutionFailedException
    ): Any {
        logger.error("ERROR ::: Received message: ${message.payload}", exception)
        return Any()
    }

    override fun handleError(
        message: Message<*>,
        exception: ListenerExecutionFailedException,
        consumer: Consumer<*, *>
    ): Any {
        return handleError(message, exception)
    }
}