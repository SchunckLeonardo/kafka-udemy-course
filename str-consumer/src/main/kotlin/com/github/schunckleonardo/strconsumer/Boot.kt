package com.github.schunckleonardo.strconsumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@SpringBootApplication
@EnableKafka
class Boot

fun main(args: Array<String>) {
    runApplication<Boot>(*args)
}
