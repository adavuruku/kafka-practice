package com.example.kafka_learn.json_annotation.anotherTry;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Created by Sherif.Abdulraheem 21/08/2024 - 21:24
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class GUIDRef {
    String sourcedId;
    String type;
}
