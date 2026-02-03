package com.github.schunckleonardo.strproducer.config

import com.github.schunckleonardo.strproducer.entities.constants.KafkaTopicConstants
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
    fun topics(): KafkaAdmin.NewTopics =
        KafkaAdmin.NewTopics(
            TopicBuilder.name(KafkaTopicConstants.STR_TOPIC).partitions(2).replicas(1).build()
        )

}