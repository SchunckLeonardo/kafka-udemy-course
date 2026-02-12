package com.github.schunckleonardo.paymentservice.service.impl

import com.github.schunckleonardo.paymentservice.model.Payment
import com.github.schunckleonardo.paymentservice.service.PaymentService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import java.io.Serializable

@Service
class PaymentServiceImpl(
    private val logger: Logger = LoggerFactory.getLogger(PaymentServiceImpl::class.java),
    private val kafkaTemplate: KafkaTemplate<String, Serializable>
) : PaymentService {

    override fun sendPayment(payment: Payment) {
        logger.info("[PaymentServiceImpl][sendPayment] ::: Sending payment: $payment")
        Thread.sleep(1000)

        logger.info("[PaymentServiceImpl][sendPayment] ::: Payment sent successfully")
        kafkaTemplate.send("payment-topic", payment)
    }

}