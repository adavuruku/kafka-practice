package com.example.kafka_learn.dto.scholastic.district;

import com.example.kafka_learn.dto.scholastic.BaseObject;
import com.example.kafka_learn.dto.scholastic.DataDto;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Sherif.Abdulraheem 09/08/2024 - 12:25
 **/
@Data
@AllArgsConstructor
public class CreateDistrict extends BaseObject {

    private DataDto data;
}
