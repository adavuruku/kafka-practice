package com.example.kafka_learn.dto.test;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * Created by Sherif.Abdulraheem 13/08/2024 - 17:09
 **/
@JsonIgnoreProperties(
        ignoreUnknown = true
)
@EqualsAndHashCode
public class SourceSystemIdentifier implements Serializable {
    private static final long serialVersionUID = 9219392784215569146L;
    @JsonProperty("source_system")
    private String sourceSystem;
    @JsonProperty("source_id")
    private String sourceId;

    public static SourceSystemIdentifierBuilder builder() {
        return new SourceSystemIdentifierBuilder();
    }

    public String getSourceSystem() {
        return this.sourceSystem;
    }

    public String getSourceId() {
        return this.sourceId;
    }

    @JsonProperty("source_system")
    public void setSourceSystem(final String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    @JsonProperty("source_id")
    public void setSourceId(final String sourceId) {
        this.sourceId = sourceId;
    }

    public SourceSystemIdentifier() {
    }

    public SourceSystemIdentifier(final String sourceSystem, final String sourceId) {
        this.sourceSystem = sourceSystem;
        this.sourceId = sourceId;
    }

    public static class SourceSystemIdentifierBuilder {
        private String sourceSystem;
        private String sourceId;

        SourceSystemIdentifierBuilder() {
        }

        @JsonProperty("source_system")
        public SourceSystemIdentifierBuilder sourceSystem(final String sourceSystem) {
            this.sourceSystem = sourceSystem;
            return this;
        }

        @JsonProperty("source_id")
        public SourceSystemIdentifierBuilder sourceId(final String sourceId) {
            this.sourceId = sourceId;
            return this;
        }

        public SourceSystemIdentifier build() {
            return new SourceSystemIdentifier(this.sourceSystem, this.sourceId);
        }

        public String toString() {
            return "SourceSystemIdentifier.SourceSystemIdentifierBuilder(sourceSystem=" + this.sourceSystem + ", sourceId=" + this.sourceId + ")";
        }
    }
}
