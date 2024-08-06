
package com.example.kafka_learn.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Sherif.Abdulraheem 22/07/2024 - 23:59
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class AuditEventDto {
    String eventAction;
    String entityName;
    String description;
    String beforeData;
    String afterData;
    Long serviceId;
    String initiatedBy; //user email
}
