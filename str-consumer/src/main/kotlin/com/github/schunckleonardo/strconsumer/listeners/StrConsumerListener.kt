package com.github.schunckleonardo.strconsumer.listeners

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class StrConsumerListener(
    private val logger: Logger = LoggerFactory.getLogger(StrConsumerListener::class.java)
) {

    @KafkaListener(
        groupId = "group-1",
        topics = ["str-topic"],
        containerFactory = "concurrentKafkaListenerContainerFactory",
        errorHandler = "errorCustomHandler"
    )
    fun create(message: String) {
        logger.info("CREATE ::: Received message: $message")
        throw RuntimeException("Test exception")
    }

    @KafkaListener(
        groupId = "group-2",
        topics = ["str-topic"],
        containerFactory = "validMessageContainerFactory",
        errorHandler = "errorCustomHandler"
    )
    fun history(message: String) {
        logger.info("HISTORY ::: Received message: $message")
    }

}