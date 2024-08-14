package com.example.kafka_learn.compare;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Sherif.Abdulraheem 12/08/2024 - 22:21
 **/
@Getter
@Setter
@AllArgsConstructor
public class SourceSystemIdentifier {
    private String sourceSystem;
    private String sourceId;
}
