package com.github.schunckleonardo.strproducer.controllers

import com.github.schunckleonardo.strproducer.services.StringProducerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/producer")
class StringProducerController(
    private val stringProducerService: StringProducerService
) {

    @PostMapping("/send")
    fun sendMessage(
        @RequestBody message: String
    ): ResponseEntity<Any> {
        stringProducerService.sendMessage(message)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

}