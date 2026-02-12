package com.github.schunckleonardo.jsonconsumer.listener

import com.github.schunckleonardo.jsonconsumer.model.Payment
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.stereotype.Component

@Component
class JsonListener(
    private val logger: Logger = LoggerFactory.getLogger(JsonListener::class.java)
) {

    @KafkaListener(
        groupId = "create-group",
        topics = ["payment-topic"],
        containerFactory = "concurrentKafkaListenerContainerFactory"
    )
    fun antiFraud(
        @Payload payment: Payment
    ) {
        logger.info("Received payment: $payment")
        Thread.sleep(2000)

        logger.info("Validating fraud...")
        Thread.sleep(2000)

        logger.info("Approved paymend")
        Thread.sleep(3000)
    }

    @KafkaListener(
        groupId = "pdf-group",
        topics = ["payment-topic"],
        containerFactory = "concurrentKafkaListenerContainerFactory"
    )
    fun pdfGenerator(
        @Payload payment: Payment
    ) {
        logger.info("Generating PDF to product id ${payment.id}...")
        Thread.sleep(2000)
    }

    @KafkaListener(
        groupId = "email-group",
        topics = ["payment-topic"],
        containerFactory = "concurrentKafkaListenerContainerFactory"
    )
    fun sendEmail() {
        logger.info("Sending confirmation email...")
        Thread.sleep(2000)
    }

}