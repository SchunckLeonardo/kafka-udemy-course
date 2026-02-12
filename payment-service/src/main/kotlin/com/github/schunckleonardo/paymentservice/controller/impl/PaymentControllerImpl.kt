package com.github.schunckleonardo.paymentservice.controller.impl

import com.github.schunckleonardo.paymentservice.controller.PaymentController
import com.github.schunckleonardo.paymentservice.model.Payment
import com.github.schunckleonardo.paymentservice.service.PaymentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/payments")
class PaymentControllerImpl(
    private val paymentService: PaymentService
) : PaymentController {

    override fun payment(payment: Payment): ResponseEntity<Any> =
        ResponseEntity.status(HttpStatus.CREATED).body(
            paymentService.sendPayment(payment)
        )

}