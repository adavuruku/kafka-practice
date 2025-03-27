package com.example.kafka_learn.json_annotation;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Map;

/**
 * Created by Sherif.Abdulraheem 20/08/2024 - 22:08
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class UserUpdate {
    String name;
    String title;
    private Map<String, Object> metadata;

//    @JsonAnyGetter
    public Map<String, Object> getMetaData() {
        return metadata;
    }

    private Map<String, String> properties;

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }
}
