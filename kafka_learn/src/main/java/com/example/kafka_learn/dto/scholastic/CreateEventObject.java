package com.example.kafka_learn.dto.scholastic;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * Created by Sherif.Abdulraheem 08/08/2024 - 23:00
 **/
@Data
public class CreateEventObject {
    //general
    private String sourcedId;
    private String status;
    private String dateLastModified;
    @JsonProperty("_rs_other_ids")
    private List<EventOtherId> rsOtherIds;

    //district
    private String name;
    private String type;
    private Map<String, Object> metadata;
    private OrgParent parent;


    //user
    private List<EventOtherId> userIds;
    private String enabledUser;
    private String givenName;
    private String familyName;
    private String role;
    private String identifier;
    private String email;

    private List<EventOrgs> orgs;

    private List<String> grades;

}