package com.example.kafka_learn.dto.scholastic;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by Sherif.Abdulraheem 08/08/2024 - 22:58
 **/
@Data
public class EventUserId {
    private String type;
    private String identifier;
}