package com.example.kafka_learn;

import com.example.kafka_learn.dto.AuditEventDto;
import com.example.kafka_learn.dto.Book;
import com.example.kafka_learn.service.KafkaProducerService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * Created by Sherif.Abdulraheem 8/3/2024 - 8:34 PM
 **/
@RequestMapping("/api/v1/kafka")
@RequiredArgsConstructor
@RestController
public class Api {
    private final KafkaProducerService kafkaProducerService;

    @PostMapping("/string")
    public ResponseEntity<Object> stringMessage(
            @RequestBody @Validated Book book, HttpServletRequest httpServletRequest)
            throws IOException {
        kafkaProducerService.sendStringMessage(book);
        return new ResponseEntity<>("Successful", CREATED);
    }

    @PostMapping("/json")
    public ResponseEntity<Object> jsonMessage(
            @RequestBody @Validated Object book, HttpServletRequest httpServletRequest)
            throws IOException {
        kafkaProducerService.sendJsonMessage(book);
        return new ResponseEntity<>("Successful", CREATED);
    }

    @PostMapping("/audit-trail")
    public ResponseEntity<Object> jsonMessage(
            @RequestBody @Validated AuditEventDto auditEventDto,
            @RequestHeader("signedPayload") String signedPayload, HttpServletRequest httpServletRequest)
            throws IOException {
        kafkaProducerService.sendAuditTrailMessage(auditEventDto, signedPayload);
        return new ResponseEntity<>("Successful", CREATED);
    }
}
