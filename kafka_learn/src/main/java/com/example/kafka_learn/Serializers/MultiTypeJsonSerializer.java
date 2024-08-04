package com.example.kafka_learn.Serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;
/**
 * Created by Sherif.Abdulraheem 8/4/2024 - 2:21 AM
 **/


public class MultiTypeJsonSerializer implements Serializer<Object> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // No-op
    }

    @Override
    public byte[] serialize(String topic, Object data) {
        if (data == null) {
            return null;
        }

        try {
            // Create a root ObjectNode to hold the type and the object data
            ObjectNode rootNode = objectMapper.createObjectNode();
            String type = data.getClass().getSimpleName();

            // Add the type field
            rootNode.put("type", type);

            // Serialize the object to a JsonNode and add it to the root node
            ObjectNode dataNode = objectMapper.valueToTree(data);
            rootNode.setAll(dataNode); // Merge fields from dataNode into rootNode

            return objectMapper.writeValueAsBytes(rootNode);
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize JSON", e);
        }
    }

    @Override
    public void close() {
        // No-op
    }
}
