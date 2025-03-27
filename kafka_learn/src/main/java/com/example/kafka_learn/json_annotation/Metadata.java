package com.example.kafka_learn.json_annotation;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sherif.Abdulraheem 21/08/2024 - 00:26
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Metadata implements Serializable {

    private static final long serialVersionUID = 5310647453085759305L;

    private Map<String, Object> additionalProperties = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String key, Object value) {
        additionalProperties.put(key, value);
    }

    public String getPropertyString(MetadataFieldEnum key) {
        Object property = this.additionalProperties.get(key.getType());

        if (property != null) {
            return StringUtils.trimToNull(String.valueOf(property));
        }

        return null;
    }
}
