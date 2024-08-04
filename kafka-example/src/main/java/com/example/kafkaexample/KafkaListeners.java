package com.example.kafkaexample;

import com.example.kafkaexample.dto.Book;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    @KafkaListener(
            topics = "amigoscode",
            groupId ="groupId"
    )
    void listener(String data){
        System.out.println("Listener Received: " + data + " :)");
    }

    @KafkaListener(
            topics = "top1",
            groupId ="groupId",
            containerFactory = "bookListener"
    )
    void listenerBook(@Payload Book book){
        System.out.println("Listener Received: " + book.getBookName() + " :)");
    }


    @KafkaListener(id = "staticAccountId", topics = "static_account_produce_topic",containerFactory="staticAccountListener")
    void listenerConsumer(@Payload String payload){
        System.out.println("Listener Received:::: " + payload + " :)");
    }
}
