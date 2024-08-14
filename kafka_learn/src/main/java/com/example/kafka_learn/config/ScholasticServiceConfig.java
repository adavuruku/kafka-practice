package com.example.kafka_learn.config;

import com.example.kafka_learn.service.ScholasticProducerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

/**
* Created by Sherif.Abdulraheem 08/08/2024 - 23:25
**/
@Configuration
public class ScholasticServiceConfig {
    @Bean
    public ScholasticProducerService scholasticProducerService(
            @Qualifier("jsonKafkaTemplate") KafkaTemplate<String, Object> kafkaJsonTemplate
    ){
        return new ScholasticProducerService( kafkaJsonTemplate);
    }
}
