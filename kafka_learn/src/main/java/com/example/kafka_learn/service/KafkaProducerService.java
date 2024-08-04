package com.example.kafka_learn.service;

import com.example.kafka_learn.dto.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Created by Sherif.Abdulraheem 8/3/2024 - 5:22 PM
 **/
@RequiredArgsConstructor
public class KafkaProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, Object> kafkaJsonTemplate;

//    @Value("${spring.kafka.template.default-topic}")
    @Value("${spring.kafka.string.default-topic}")
    private String stringTopic;

    @Value("${spring.kafka.json.default-topic}")
    private String jsonTopic;


    private static final String KEY = "message";


    public void sendStringMessage(Book message) {

        try {
            long timestamp = System.currentTimeMillis();
            List<Header> headers = new ArrayList<>();
            headers.add(new RecordHeader(KafkaHeaders.RECEIVED_TIMESTAMP, String.valueOf(timestamp).getBytes(StandardCharsets.UTF_8)));
            headers.add(new RecordHeader(KafkaHeaders.RECEIVED_KEY, KEY.getBytes(StandardCharsets.UTF_8)));
            headers.add(new RecordHeader("eventType", "StringEvent".getBytes(StandardCharsets.UTF_8)));
            headers.add(new RecordHeader("id", UUID.randomUUID().toString().replace("-","").getBytes()));

            ProducerRecord<String,String> record = new ProducerRecord<>(stringTopic, 0, KEY, message.getBookName(), headers);
            kafkaTemplate.send(record);

            headers.add(new RecordHeader("eventType", "StringBookEvent".getBytes(StandardCharsets.UTF_8)));
            String payload = new ObjectMapper().writeValueAsString(message);
            record = new ProducerRecord<>(stringTopic, 0, KEY, payload, headers);
            kafkaTemplate.send(record);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    public void sendJsonMessage(Object message) {
        long timestamp = System.currentTimeMillis();
        List<Header> headers = new ArrayList<>();
        headers.add(new RecordHeader(KafkaHeaders.RECEIVED_TIMESTAMP, String.valueOf(timestamp).getBytes(StandardCharsets.UTF_8)));
        headers.add(new RecordHeader(KafkaHeaders.RECEIVED_KEY, KEY.getBytes(StandardCharsets.UTF_8)));
        headers.add(new RecordHeader("eventType", "JsonEvent".getBytes(StandardCharsets.UTF_8)));
        headers.add(new RecordHeader("id", UUID.randomUUID().toString().replace("-","").getBytes()));

        ProducerRecord<String,Object> record = new ProducerRecord<>(jsonTopic, 0, KEY, message, headers);
        kafkaJsonTemplate.send(record);
    }
}
