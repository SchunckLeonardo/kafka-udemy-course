package com.github.schunckleonardo.jsonconsumer.config

import com.github.schunckleonardo.jsonconsumer.model.Payment
import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.JsonDeserializer

@EnableKafka
@Configuration
class KafkaConsumerConfig(
    private val kafkaProperties: KafkaProperties
) {

    @Bean
    fun consumerFactory(): ConsumerFactory<String, Payment> {
        val deserializer = JsonDeserializer(Payment::class.java).apply {
            setUseTypeHeaders(false)
            addTrustedPackages("com.github.schunckleonardo.jsonconsumer.model")
        }

        val props = mapOf(
            ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG to StringDeserializer::class.java,
            ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG to deserializer::class.java,
            ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG to kafkaProperties.bootstrapServers
        )

        return DefaultKafkaConsumerFactory(props, StringDeserializer(), deserializer)
    }

    @Bean(name = ["concurrentKafkaListenerContainerFactory"])
    fun concurrentKafkaListenerContainerFactory(
        consumerFactory: ConsumerFactory<String, Payment>
    ): ConcurrentKafkaListenerContainerFactory<String, Payment> {
        return ConcurrentKafkaListenerContainerFactory<String, Payment>().apply {
            this.consumerFactory = consumerFactory
        }
    }
}