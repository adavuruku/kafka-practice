package com.example.kafka_learn.compare;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

/**
 * Created by Sherif.Abdulraheem 12/08/2024 - 22:15
 **/
@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private UUID id;
    private String email;
    private String givenName;
    private String middleName;
    private String familyName;
    private String type;
    private String gender;
    private Date dob;
    private String username;
    private String password;
    private String grade;
    private Set<SourceSystemIdentifier> sourceSystemIdentifiers;

    private Set<UserMetaData> userMetadata;
}
