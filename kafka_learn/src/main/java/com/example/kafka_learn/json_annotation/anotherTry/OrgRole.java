package com.example.kafka_learn.json_annotation.anotherTry;

import com.example.kafka_learn.json_annotation.RoleType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * Created by Sherif.Abdulraheem 21/08/2024 - 21:24
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class OrgRole  {
    List<GUIDRef> orgs;
    RoleType role;
}
