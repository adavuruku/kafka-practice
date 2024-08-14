package com.example.kafka_learn.service;

import com.example.kafka_learn.dto.scholastic.user.CreateUser;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * Created by Sherif.Abdulraheem 8/3/2024 - 5:22 PM
 **/
@RequiredArgsConstructor
public class ScholasticProducerService {
    private final KafkaTemplate<String, Object> kafkaJsonTemplate;

    @Value("${spring.kafka.scholastic.inbound-topic}")
    private String edTopic;


    private static final String KEY = "message";

    public void sendJson(Object message) {
         ProducerRecord<String,Object> record = new ProducerRecord<>(edTopic, 0, null, message);
        kafkaJsonTemplate.send(record);
    }
}
