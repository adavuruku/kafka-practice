package com.example.testconsumer.config;

import com.example.testconsumer.dto.Book;
import com.example.testconsumer.dto.Card;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

// Annotation
@Configuration
public class KafkaBookProducerConfig {

    @Bean
    public ProducerFactory<String, Card> bookProducerFactory()
    {

        // Creating a Map
        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                "127.0.0.1:9092");
        config.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class);
        config.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                JsonSerializer.class);

        config.put(ConsumerConfig.GROUP_ID_CONFIG, "groupId");

        return new DefaultKafkaProducerFactory<>(config);
    }

    @Bean
    public KafkaTemplate kafkaBookTemplate()
    {
        return new KafkaTemplate<>(bookProducerFactory());
    }
}
