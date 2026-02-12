package com.github.schunckleonardo.paymentservice.service

import com.github.schunckleonardo.paymentservice.model.Payment

interface PaymentService {

    fun sendPayment(payment: Payment)

}