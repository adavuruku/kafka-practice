package com.example.kafka_learn.json_annotation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by Sherif.Abdulraheem 21/08/2024 - 00:34
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserUpdateBaseModel implements Serializable, Test {

    private static final long serialVersionUID = -3306593703274268427L;

    String name;
    String title;

    private Metadata metadata;

}