package com.github.schunckleonardo.paymentservice.controller

import com.github.schunckleonardo.paymentservice.model.Payment
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

interface PaymentController {

    @PostMapping
    fun payment(
        @RequestBody payment: Payment
    ): ResponseEntity<Any>

}