package com.example.kafka_learn.json_annotation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

/*
 * The set of permitted tokens for the type of role.
 */
@AllArgsConstructor
public enum RoleType {

    ADMINISTRATOR("administrator"), // Administrator in the organization (e.g. School). May be used for enrollment.
    AIDE("aide"), // Someone who provides appropriate aide to the user but NOT also one of the other roles.
    GUARDIAN("guardian"), // Guardian of the user and NOT the Mother or Father. May also be a Relative.
    PARENT("parent"), // Mother or father of the user.
    PROCTOR("proctor"), // Exam proctor. Added in V1.1. May be used for enrollment.
    RELATIVE("relative"), // A relative of the user and NOT the Mother or Father. May also be the Guardian.
    STUDENT("student"), // A student at a organization (e.g. School). May be used for enrollment.
    TEACHER("teacher"); // A Teacher at organization (e.g. School). May be used for enrollment.

    @Getter
    @JsonValue
    private String type;

    @JsonCreator
    public static RoleType fromType(String type) {
        return valueOf(RoleType.class, StringUtils.upperCase(type));
    }

}
