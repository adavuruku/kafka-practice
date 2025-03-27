package com.example.kafka_learn.config;

import com.example.kafka_learn.dto.AuditEventDto;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created by Sherif.Abdulraheem 09/10/2024 - 12:27
 **/
public class AuditEventDtoDataDeserializer extends JsonDeserializer<AuditEventDto> {
    @Override
    public AuditEventDto deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        return new AuditEventDto(
                node.get("eventAction").asText(),
                node.get("entityName").asText(),
                node.get("description").asText(),
                node.get("beforeData").asText(),
                node.get("afterData").asText(),
                node.get("serviceId").asLong(),
                node.get("initiatedBy").asText()
        );
    }
}
