package com.example.kafka_learn.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

import java.nio.ByteBuffer;
import java.time.Instant;
import java.util.HexFormat;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
public class KafkaConsumer {
    private final EventHandler eventHandler;

    private static final List<String> supportedStringEventTypes = List.of(
            "StringEvent",
            "StringBookEvent",
            "ProtoEvent",
            "AvroEvent",
            "JsonEvent"
    );

    @KafkaListener(topics = "${spring.kafka.string.default-topic}", groupId = "${spring.kafka.test.group-id}")
    public void onMessage(@Header("id") String id, @Header("eventType") String eventType, @Header(name = KafkaHeaders.RECEIVED_KEY, required = false) String key, @Payload String payload, @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long timestamp) {
        ByteBuffer buf = ByteBuffer.wrap(HexFormat.of().parseHex(id));
        UUID eventId = new UUID(buf.getLong(), buf.getLong());
        log.info("Received 'Transaction' event -- key: {}, event id: '{}', event type: '{}', timestamp: '{}', payload: '{}'", key, eventId, eventType, timestamp, payload);
        if (supportedStringEventTypes.stream().anyMatch(event -> event.equals(eventType))) {
            log.info("Processing supported event: " + eventType);
            eventHandler.onStringTransactionEvent(eventId, eventType, key, payload, Instant.ofEpochMilli(timestamp));
        } else {
            log.info("Skipping unsupported event: " + eventType);
        }
    }

//    @KafkaListener(topics = "${spring.kafka.json.default-topic}", groupId = "${spring.kafka.test.group-id}")
//    public void onJsonMessage(@Header("id") String id, @Header("eventType") String eventType, @Header(name = KafkaHeaders.RECEIVED_KEY, required = false) String key, @Payload ConsumerRecord<String, String> payload, @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long timestamp) {
//
//        ByteBuffer buf = ByteBuffer.wrap(HexFormat.of().parseHex(id));
//        UUID eventId = new UUID(buf.getLong(), buf.getLong());
//
//        log.info("Received 'Transaction' event -- key: {}, event id: '{}', event type: '{}', timestamp: '{}', payload: '{}'", key, eventId, eventType, timestamp, payload);
//        if (supportedStringEventTypes.stream().anyMatch(event -> event.equals(eventType))) {
//            log.info("Processing supported event: " + eventType);
//            eventHandler.onJsonTransactionEvent(eventId, eventType, key, payload, Instant.ofEpochMilli(timestamp));
//        } else {
//            log.info("Skipping unsupported event: " + eventType);
//        }
//    }

    @KafkaListener(topics = "${spring.kafka.json.default-topic}", groupId = "${spring.kafka.test.group-id}")
    public void onJsonMessage(@Header("id") String id, @Header("eventType") String eventType, @Header(name = KafkaHeaders.RECEIVED_KEY, required = false) String key, @Payload String payload, @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long timestamp) {

        ByteBuffer buf = ByteBuffer.wrap(HexFormat.of().parseHex(id));
        UUID eventId = new UUID(buf.getLong(), buf.getLong());

        log.info("Received 'Transaction' event -- key: {}, event id: '{}', event type: '{}', timestamp: '{}', payload: '{}'", key, eventId, eventType, timestamp, payload);
        if (supportedStringEventTypes.stream().anyMatch(event -> event.equals(eventType))) {
            log.info("Processing supported event: " + eventType);
            eventHandler.onJsonTransactionEvent(eventId, eventType, key, payload, Instant.ofEpochMilli(timestamp));
        } else {
            log.info("Skipping unsupported event: " + eventType);
        }
    }
}
