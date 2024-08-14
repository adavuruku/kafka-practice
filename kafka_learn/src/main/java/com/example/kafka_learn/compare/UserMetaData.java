package com.example.kafka_learn.compare;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Sherif.Abdulraheem 12/08/2024 - 22:19
 **/
@Getter
@Setter
@AllArgsConstructor
public class UserMetaData {
    private String attributeKey;
    private String attributeValue;
}
