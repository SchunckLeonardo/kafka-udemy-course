package com.github.schunckleonardo.strproducer.services

import com.github.schunckleonardo.strproducer.entities.constants.KafkaTopicConstants
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class StringProducerService(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    fun sendMessage(message: String) {
        kafkaTemplate.send(
            KafkaTopicConstants.STR_TOPIC, message
        )
    }

}