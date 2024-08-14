package com.example.kafka_learn.dto.test;

import lombok.EqualsAndHashCode;

/**
 * Created by Sherif.Abdulraheem 14/08/2024 - 00:09
 **/
@EqualsAndHashCode(callSuper = true, exclude = {"username", "gender", "grade", "password", "dob"})
public class UserV3 extends UserV2{

}
