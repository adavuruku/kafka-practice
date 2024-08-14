package com.example.kafka_learn.dto.scholastic;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Created by Sherif.Abdulraheem 09/08/2024 - 12:26
 **/
@Data
public class BaseObject {
    private String id;
    @JsonProperty("datasource_id")
    private String datasourceId;
//    @JsonProperty("external_id")
    private String externalId;
    private String entity;
    private String action;

    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
}
