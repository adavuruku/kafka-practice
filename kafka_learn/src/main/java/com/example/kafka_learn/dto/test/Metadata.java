package com.example.kafka_learn.dto.test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Created by Sherif.Abdulraheem 13/08/2024 - 17:10
 **/
@JsonIgnoreProperties(
        ignoreUnknown = true
)
@EqualsAndHashCode
public class Metadata implements Serializable {
    private static final long serialVersionUID = -5110133139889601010L;
    @JsonProperty("attribute_key")
    private String attributeKey;
    @JsonProperty("attribute_value")
    private String attributeValue;

    public static MetadataBuilder builder() {
        return new MetadataBuilder();
    }

    public String getAttributeKey() {
        return this.attributeKey;
    }

    public String getAttributeValue() {
        return this.attributeValue;
    }

    @JsonProperty("attribute_key")
    public void setAttributeKey(final String attributeKey) {
        this.attributeKey = attributeKey;
    }

    @JsonProperty("attribute_value")
    public void setAttributeValue(final String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public Metadata() {
    }

    public Metadata(final String attributeKey, final String attributeValue) {
        this.attributeKey = attributeKey;
        this.attributeValue = attributeValue;
    }

    public static class MetadataBuilder {
        private String attributeKey;
        private String attributeValue;

        MetadataBuilder() {
        }

        @JsonProperty("attribute_key")
        public MetadataBuilder attributeKey(final String attributeKey) {
            this.attributeKey = attributeKey;
            return this;
        }

        @JsonProperty("attribute_value")
        public MetadataBuilder attributeValue(final String attributeValue) {
            this.attributeValue = attributeValue;
            return this;
        }

        public Metadata build() {
            return new Metadata(this.attributeKey, this.attributeValue);
        }

        public String toString() {
            return "Metadata.MetadataBuilder(attributeKey=" + this.attributeKey + ", attributeValue=" + this.attributeValue + ")";
        }
    }
}
