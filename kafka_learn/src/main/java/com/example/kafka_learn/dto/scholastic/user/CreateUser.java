package com.example.kafka_learn.dto.scholastic.user;

import com.example.kafka_learn.dto.scholastic.BaseObject;
import com.example.kafka_learn.dto.scholastic.DataDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Sherif.Abdulraheem 08/08/2024 - 22:48
 **/
@Data
@NoArgsConstructor
public class CreateUser extends BaseObject {
    private DataDto data;
}
