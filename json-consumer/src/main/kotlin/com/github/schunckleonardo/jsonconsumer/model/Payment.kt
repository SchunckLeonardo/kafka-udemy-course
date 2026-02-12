package com.github.schunckleonardo.jsonconsumer.model

import java.io.Serializable

data class Payment(
    val id: Long,
    val idUser: Long,
    val idProduct: Long,
    val cardNumber: String
) : Serializable
