package com.Hmac.vansoMock.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder({"id", "sessionId", "msisdn", "imsi", "starcode", "query", "input", "sessionData", "sessionStart", "data"})
@Setter
@Getter
public class TelcoRequest extends BaseRequestDto{


    @JsonProperty("sessionData")
    private Telco telco;
}
