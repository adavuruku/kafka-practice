package com.Hmac.vansoMock.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class UssdGatewayResponse {

    private String message;
    private String destination;
    private Boolean success;
    private String error;
    private String errorMessage;
    private String menuDestination;
    private List<MenuItem> menu;
    private Object sessionData;
    private Boolean sessionEnd;

}
