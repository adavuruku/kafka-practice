package com.example.kafka_learn.json_annotation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by Sherif.Abdulraheem 21/08/2024 - 00:33
 **/
@AllArgsConstructor
public enum MetadataFieldEnum {

    UCN("ucn"),
    PARENTUCN("parentUcn"),
    ACADEMIC_SESSION("academicSession");

    @Getter
    @JsonValue
    private String type;

    @JsonCreator
    public static MetadataFieldEnum fromType(String type) {
        return valueOf(MetadataFieldEnum.class, StringUtils.upperCase(type));
    }

}