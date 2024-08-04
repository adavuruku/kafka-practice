package com.example.kafkaexample.config;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaMultiTypeProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    /** Note: TYPE_MAPPING -> specify the full package of the Object(class) that
     * Can be used on the producer e.g Course and Student Object(class)
     * course:com.example.kafkaexample.dto.Course
     * student:com.example.kafkaexample.dto.Student
     * */
    public Map<String, Object> multiTypeProducerConfig(){
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        configProps.put(JsonSerializer.TYPE_MAPPINGS,
                "course:com.example.kafkaexample.dto.Course, student:com.example.kafkaexample.dto.Student");

        return configProps;
    }

    @Bean
    public ProducerFactory<String, Object> multiTypeProducerFactory() {
        return new DefaultKafkaProducerFactory<>(multiTypeProducerConfig());
    }

    @Bean
    public KafkaTemplate<String, Object> multiTypeKafkaTemplate() {
        return new KafkaTemplate<>(multiTypeProducerFactory());
    }
}
