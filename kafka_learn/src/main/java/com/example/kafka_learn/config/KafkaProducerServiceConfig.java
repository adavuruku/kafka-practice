package com.example.kafka_learn.config;

import com.example.kafka_learn.dto.AuditEventDto;
import com.example.kafka_learn.dto.Transaction;
import com.example.kafka_learn.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * Created by Sherif.Abdulraheem 8/3/2024 - 6:59 PM
 **/
@Configuration
public class KafkaProducerServiceConfig {
    @Bean
    public KafkaProducerService createKafkaProducerService(
            KafkaTemplate<String, String> kafkaTemplate,
            @Qualifier("jsonKafkaTemplate") KafkaTemplate<String, Object> kafkaJsonTemplate,
            @Qualifier("auditTrailKafkaTemplate") KafkaTemplate<String, AuditEventDto> kafkaAuditEventTemplate,
            @Qualifier("consumerServiceKafkaTemplate") KafkaTemplate<String, Transaction> kafkaConsumerServiceTemplate
            ){
        return new KafkaProducerService(kafkaTemplate, kafkaJsonTemplate, kafkaAuditEventTemplate, kafkaConsumerServiceTemplate);
    }
}
