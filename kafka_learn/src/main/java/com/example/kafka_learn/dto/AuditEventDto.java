
package com.example.kafka_learn.dto;

import com.example.kafka_learn.config.AuditEventDtoDataDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Sherif.Abdulraheem 22/07/2024 - 23:59
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonDeserialize(using = AuditEventDtoDataDeserializer.class)
public class AuditEventDto {
    String eventAction;
    String entityName;
    String description;
    String beforeData;
    String afterData;
    Long serviceId;
    String initiatedBy; //user email
}
