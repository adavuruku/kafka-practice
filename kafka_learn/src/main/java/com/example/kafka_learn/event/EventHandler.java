package com.example.kafka_learn.event;

import com.example.kafka_learn.dto.Book;
import com.example.kafka_learn.dto.Course;
import com.example.kafka_learn.dto.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by Sherif.Abdulraheem 8/3/2024 - 11:07 PM
 **/
@Slf4j
public class EventHandler {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    public void onStringTransactionEvent(UUID eventId, String eventType, String key, String payload, Instant timestamp) {
        try {
            log.info("Received 'Transaction' event -- key: {}, event id: '{}', event type: '{}', timestamp: '{}'", key, eventId, eventType, timestamp);
            switch (eventType) {
                case "StringEvent" -> handleStringEvent(payload);
                case "StringBookEvent" -> handleStringBookEvent(payload);
//                case "PaymentApprovalLogged" -> handlePaymentApprovalLoggedEvent(transaction);
                default -> log.warn("Unknown event type");
            }

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

//    public void onJsonTransactionEvent(UUID eventId, String eventType, String key, ConsumerRecord<String, String> payload, Instant timestamp) {
//        try {
//            log.info("Received 'Transaction' event -- key: {}, event id: '{}', event type: '{}', timestamp: '{}'", key, eventId, eventType, timestamp);
//            switch (eventType) {
//                case "JsonEvent" -> handleJsonEvent(payload);
//                default -> log.warn("Unknown event type");
//            }
//
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//    }

    public void onJsonTransactionEvent(UUID eventId, String eventType, String key, String payload, Instant timestamp) {
        try {
            log.info("Received 'Transaction' event -- key: {}, event id: '{}', event type: '{}', timestamp: '{}'", key, eventId, eventType, timestamp);
            switch (eventType) {
                case "JsonEvent" -> handleJsonEvent(payload);
                default -> log.warn("Unknown event type");
            }

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void handleStringBookEvent(String payload){
        try {
            OBJECT_MAPPER.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
            OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            OBJECT_MAPPER.registerModule(new JavaTimeModule());

//            JsonNode event = OBJECT_MAPPER.readValue(payload, JsonNode.class);
//            String transactionJson = Objects.isNull(event.asText()) || StringUtils.isEmpty(event.asText().trim()) ? payload : event.asText();
            Book book = OBJECT_MAPPER.readValue(payload, Book.class);
            log.info("Received Book {}", OBJECT_MAPPER.writeValueAsString(book));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void handleStringEvent(String message){
        try {
            log.info("Received message {}", message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    public void handleJsonEvent(ConsumerRecord<String, String>  payload){
//        try {
//            OBJECT_MAPPER.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
//            OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//            OBJECT_MAPPER.registerModule(new JavaTimeModule());
//            // Deserialize payload to JsonNode
//            JsonNode jsonNode = OBJECT_MAPPER.readTree(payload.value());
//
//            // Extract the type field to determine the object type
//            String type = jsonNode.get("type").asText();
//
//            // Process based on the type
//            switch (type) {
//                case "Book":
//                    Book book = OBJECT_MAPPER.treeToValue(jsonNode, Book.class);
//                    log.info("Received Book {}", OBJECT_MAPPER.writeValueAsString(book));
//                    break;
//                case "Course":
//                    Course course = OBJECT_MAPPER.treeToValue(jsonNode, Course.class);
//                    log.info("Received Course {}", OBJECT_MAPPER.writeValueAsString(course));
//                    break;
//                case "Student":
//                    Student student = OBJECT_MAPPER.treeToValue(jsonNode, Student.class);
//                    log.info("Received Student {}", OBJECT_MAPPER.writeValueAsString(student));
//                    break;
//                default:
//                    System.out.println("Unknown type: " + type);
//                    break;
//            }
//
//        } catch (Exception e) {
//            System.err.println("Failed to process message: " + e.getMessage());
//        }
//    }

    public void handleJsonEvent(String  payload){
        try {
            OBJECT_MAPPER.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
            OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            OBJECT_MAPPER.registerModule(new JavaTimeModule());
            // Deserialize payload to JsonNode
            JsonNode jsonNode = OBJECT_MAPPER.readTree(payload);

            // Extract the type field to determine the object type
            String type = jsonNode.get("type").asText();

            // Process based on the type
            switch (type) {
                case "Book":
                    Book book = OBJECT_MAPPER.treeToValue(jsonNode, Book.class);
                    log.info("Received Book {}", OBJECT_MAPPER.writeValueAsString(book));
                    break;
                case "Course":
                    Course course = OBJECT_MAPPER.treeToValue(jsonNode, Course.class);
                    log.info("Received Course {}", OBJECT_MAPPER.writeValueAsString(course));
                    break;
                case "Student":
                    Student student = OBJECT_MAPPER.treeToValue(jsonNode, Student.class);
                    log.info("Received Student {}", OBJECT_MAPPER.writeValueAsString(student));
                    break;
                default:
                    System.out.println("Unknown type: " + type);
                    break;
            }

        } catch (Exception e) {
            System.err.println("Failed to process message: " + e.getMessage());
        }
    }
}
