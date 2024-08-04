package com.Hmac.vansoMock.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class BaseRequestDto {

    @JsonProperty("id")
    private String id;

    @JsonProperty("sessionId")
    private String sessionId;


    @JsonProperty("msisdn")
    private String msisdn;

    @JsonProperty("imsi")
    private String imsi;

    @JsonProperty("starcode")
    private String starcode;

    @JsonProperty("query")
    private String query;

    @JsonProperty("input")
    private String input;

    @JsonProperty("sessionStart")
    private Boolean sessionStart;

    @JsonProperty("data")
    private Object data;

}
