package com.github.schunckleonardo.paymentservice.model

data class Payment(
    val id: Long,
    val idUser: Long,
    val idProduct: Long,
    val cardNumber: String
)
