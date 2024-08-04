package com.example.testconsumer;

import com.example.testconsumer.dto.Book;
import com.example.testconsumer.dto.Card;
import com.example.testconsumer.dto.metadata;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.kafka.clients.Metadata;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.util.SerializationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1")
public class MessageController {
    public MessageController(KafkaTemplate<String, Card> kafkaBookTemplate) {
        this.kafkaBookTemplate = kafkaBookTemplate;
    }

    private KafkaTemplate<String, Card> kafkaBookTemplate;

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String KEY = "message";

    @PostMapping("/publish")
    public String publishMessage(@RequestBody Card card)
    {
        try {
//        ObjectNode asJson = OBJECT_MAPPER.createObjectNode()
//                .put("bookName", book.getBookName())
//                .put("isbn", book.getIsbn());

//        byte[] jsonBytes = SerializationUtils.serialize(asJson);
        UUID uuid = UUID.randomUUID();

        System.out.println("meta data "+ card.getAccountNo());
//        "metadata":{"saveCard":true, "config":"Maggy"}
        metadata metadata = new metadata(true,"Maggy");

            String r = new ObjectMapper().writeValueAsString(metadata);
//
//card.setMetadata(r);

        List<Header> headers = new ArrayList<>();
        headers.add(new RecordHeader("eventType", "TransactionCompleted".getBytes()));
        headers.add(new RecordHeader("id",uuid.toString().replace("-","").getBytes()));

        ProducerRecord<String, Card> record = new ProducerRecord <>("Transaction.events", 0, KEY, card, headers);
        kafkaBookTemplate.send(record);

        // Sending the message
//        kafkaBookTemplate.send("Transaction.events", book);
        return "Published Successfully";
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/add-card-requested")
    public String publishAddCardRequesMessage(@RequestBody Card card)
    {
        try {
            UUID uuid = UUID.randomUUID();

            List<Header> headers = new ArrayList<>();
            headers.add(new RecordHeader("eventType", "AddCardRequested".getBytes()));
            headers.add(new RecordHeader("id",uuid.toString().replace("-","").getBytes()));

            ProducerRecord<String, Card> record = new ProducerRecord <>("Transaction.events", 0, KEY, card, headers);
            kafkaBookTemplate.send(record);

            return "Published Successfully";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/payment-logged")
    public String publishPaymentLoggedRequesMessage(@RequestBody Card card)
    {
        try {
            UUID uuid = UUID.randomUUID();

            List<Header> headers = new ArrayList<>();
            headers.add(new RecordHeader("eventType", "PaymentApprovalLogged".getBytes()));
            headers.add(new RecordHeader("id",uuid.toString().replace("-","").getBytes()));

            ProducerRecord<String, Card> record = new ProducerRecord <>("Transaction.events", 0, KEY, card, headers);
            kafkaBookTemplate.send(record);

            return "Published Successfully";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
