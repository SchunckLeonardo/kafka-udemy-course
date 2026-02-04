package com.github.schunckleonardo.strproducer.services

import com.github.schunckleonardo.strproducer.entities.constants.KafkaTopicConstants
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class StringProducerService(
    private val kafkaTemplate: KafkaTemplate<String, String>,
    private val logger: Logger = LoggerFactory.getLogger(StringProducerService::class.java)
) {

    fun sendMessage(message: String) {
        logger.info("Sending message: $message")
        sendMessageWithKey(
            KafkaTopicConstants.STR_TOPIC, message
        )  { success ->
            if (!success) logger.error("Failed to send message to topic: ${KafkaTopicConstants.STR_TOPIC}")
        }
    }

    private fun sendMessageWithKey(topic: String, message: String, response: (success: Boolean) -> Unit) {
        val sendResult = kafkaTemplate.send(
            topic, message
        )

        if (sendResult.isCompletedExceptionally) response(false) else response(true)
    }

}