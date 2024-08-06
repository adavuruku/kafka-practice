package com.example.kafka_learn;

import com.example.kafka_learn.dto.Transaction;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/consumer")
public class ConsumerAPI {
    private KafkaTemplate<String, Transaction> kafkaBookTemplate;

    public ConsumerAPI(KafkaTemplate<String, Transaction> kafkaBookTemplate) {
        this.kafkaBookTemplate = kafkaBookTemplate;
    }


    private static final String KEY = "message";

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Transaction card)
    {
        try {
            UUID uuid = UUID.randomUUID();
        List<Header> headers = new ArrayList<>();
        headers.add(new RecordHeader("eventType", "TransactionCompleted".getBytes()));
        headers.add(new RecordHeader("id",uuid.toString().replace("-","").getBytes()));

        ProducerRecord<String, Transaction> record = new ProducerRecord <>("Transaction.events", 0, KEY, card, headers);
        kafkaBookTemplate.send(record);
        return "Published Successfully";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/add-card-requested")
    public String publishAddCardRequesMessage(@RequestBody Transaction card)
    {
        try {
            UUID uuid = UUID.randomUUID();

            List<Header> headers = new ArrayList<>();
            headers.add(new RecordHeader("eventType", "AddCardRequested".getBytes()));
            headers.add(new RecordHeader("id",uuid.toString().replace("-","").getBytes()));

            ProducerRecord<String, Transaction> record = new ProducerRecord <>("Transaction.events", 0, KEY, card, headers);
            kafkaBookTemplate.send(record);

            return "Published Successfully";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/payment-logged")
    public String publishPaymentLoggedRequesMessage(@RequestBody Transaction card)
    {
        try {
            UUID uuid = UUID.randomUUID();

            List<Header> headers = new ArrayList<>();
            headers.add(new RecordHeader("eventType", "PaymentApprovalLogged".getBytes()));
            headers.add(new RecordHeader("id",uuid.toString().replace("-","").getBytes()));

            ProducerRecord<String, Transaction> record = new ProducerRecord <>("Transaction.events", 0, KEY, card, headers);
            kafkaBookTemplate.send(record);

            return "Published Successfully";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
