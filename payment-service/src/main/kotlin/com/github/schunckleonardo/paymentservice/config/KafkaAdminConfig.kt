package com.github.schunckleonardo.paymentservice.config

import org.apache.kafka.clients.admin.AdminClientConfig
import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder
import org.springframework.kafka.core.KafkaAdmin

@Configuration
class KafkaAdminConfig(
    private val kafkaProperties: KafkaProperties
) {

    @Bean
    fun kafkaAdmin(): KafkaAdmin {
        val configs = hashMapOf<String, Any>(
            AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG to kafkaProperties.bootstrapServers
        )
        return KafkaAdmin(configs)
    }

    @Bean
    fun newTopics(): KafkaAdmin.NewTopics =
        KafkaAdmin.NewTopics(
            TopicBuilder.name("payment-topic").partitions(1).build()
        )

}