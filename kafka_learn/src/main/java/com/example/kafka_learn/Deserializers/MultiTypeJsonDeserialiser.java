package com.example.kafka_learn.Deserializers;

/**
 * Created by Sherif.Abdulraheem 8/4/2024 - 2:09 AM
 **/

import com.example.kafka_learn.dto.Book;
import com.example.kafka_learn.dto.Course;
import com.example.kafka_learn.dto.Student;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.kafka.common.serialization.Deserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class MultiTypeJsonDeserialiser implements Deserializer<Object> {

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // No-op
    }

    @Override
    public Object deserialize(String topic, byte[] data) {
        if (data == null) {
            return null;
        }

        try {
            JsonNode jsonNode = objectMapper.readTree(data);
            String type = jsonNode.get("type").asText();

            switch (type) {
                case "Book":
                    return objectMapper.treeToValue(jsonNode, Book.class);
                case "Course":
                    return objectMapper.treeToValue(jsonNode, Course.class);
                case "Student":
                    return objectMapper.treeToValue(jsonNode, Student.class);
                default:
                    throw new IllegalArgumentException("Unknown type: " + type);
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize JSON", e);
        }
    }

    @Override
    public void close() {
        // No-op
    }
}
