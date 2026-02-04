package com.github.schunckleonardo.strconsumer.listeners.custom

import org.springframework.core.annotation.AliasFor
import org.springframework.kafka.annotation.KafkaListener

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.ANNOTATION_CLASS)
@KafkaListener
annotation class StrConsumerCustomListener(
    @get:AliasFor(annotation = KafkaListener::class, attribute = "topics") val topics: Array<String> = ["str-topic"],
    @get:AliasFor(annotation = KafkaListener::class, attribute = "containerFactory") val containerFactory: String = "concurrentKafkaListenerContainerFactory",
    @get:AliasFor(annotation = KafkaListener::class, attribute = "groupId") val groupId: String
)