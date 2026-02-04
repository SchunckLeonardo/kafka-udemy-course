package com.github.schunckleonardo.strconsumer.listeners

import com.github.schunckleonardo.strconsumer.listeners.custom.StrConsumerCustomListener
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class StrConsumerListener(
    private val logger: Logger = LoggerFactory.getLogger(StrConsumerListener::class.java)
) {

    @StrConsumerCustomListener(groupId = "group-1")
    fun create(message: String) {
        logger.info("CREATE ::: Received message: $message")
    }

}