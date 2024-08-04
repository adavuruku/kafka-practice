package com.Hmac.vansoMock.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Message {
    private String timeStamp;
    private String signature;
}
