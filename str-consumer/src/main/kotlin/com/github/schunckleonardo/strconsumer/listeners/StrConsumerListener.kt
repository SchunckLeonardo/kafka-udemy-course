package com.github.schunckleonardo.strconsumer.listeners

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class StrConsumerListener(
    private val logger: Logger = LoggerFactory.getLogger(StrConsumerListener::class.java)
) {

    @KafkaListener(groupId = "group-1", topics = ["str-topic"], containerFactory = "concurrentKafkaListenerContainerFactory")
    fun create(message: String) {
        logger.info("Received message: $message")
    }

}