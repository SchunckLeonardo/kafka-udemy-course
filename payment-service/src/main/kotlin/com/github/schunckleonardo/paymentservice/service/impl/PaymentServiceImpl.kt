package com.github.schunckleonardo.paymentservice.service.impl

import com.github.schunckleonardo.paymentservice.model.Payment
import com.github.schunckleonardo.paymentservice.service.PaymentService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class PaymentServiceImpl(
    private val logger: Logger = LoggerFactory.getLogger(PaymentServiceImpl::class.java)
) : PaymentService {

    override fun sendPayment(payment: Payment) {
        logger.info("[PaymentServiceImpl][sendPayment] ::: Sending payment: $payment")
    }

}