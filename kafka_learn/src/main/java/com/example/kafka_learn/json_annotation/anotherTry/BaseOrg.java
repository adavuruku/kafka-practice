package com.example.kafka_learn.json_annotation.anotherTry;

import com.example.kafka_learn.json_annotation.RoleType;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sherif.Abdulraheem 21/08/2024 - 21:26
 **/
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class BaseOrg {
    @JsonProperty("other_roles")
    Map<String, OrgRole> otherRoles;

    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String key, Object value) {
        additionalProperties.put(key, value);
    }

}
