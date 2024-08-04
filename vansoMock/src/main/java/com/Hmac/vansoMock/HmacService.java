package com.Hmac.vansoMock;

import com.Hmac.vansoMock.model.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
@Slf4j
public class HmacService {

    @Value("${system.Hmac.secret.key}")
    private String secretKey;

    private final Client client;
    private final ObjectMapper mapper;

    public UssdGatewayResponse signupUser(SignUpRequest request) throws JsonProcessingException {
        String path = "/api/v1/ussds/consumers/signup/offline";
        String body = mapper.writeValueAsString(request);
        Message message = generateHMAC(path, body);
        return client.signup(request, message.getTimeStamp(), message.getSignature());
    }
    public UssdGatewayResponse signUpOnline(SignUpOnlineRequest request) throws JsonProcessingException {
        String path = "/api/v1/ussds/consumers/signup";
        String body = mapper.writeValueAsString(request);
        Message message = generateHMAC(path, body);
        return client.signupOnline(request, message.getTimeStamp(), message.getSignature());
    }

    public Object exists(SignUpOnlineRequest request) throws JsonProcessingException {
        String path = "/api/v1/ussds/consumers/exist";
        String body =  mapper.writeValueAsString(request);
        Message message = generateHMAC(path, body);
        return client.checkExist(request, message.getTimeStamp(), message.getSignature());
    }

    public Message generateHMAC(String path, String body){
        String timestamp = String.valueOf(System.currentTimeMillis());
        String macString = path + timestamp + body;
        String signature = HMAC.generateHMACSignature(macString, secretKey);
        return Message.builder()
                .timeStamp(timestamp)
                .signature(signature)
                .build();
    }

    public Object telcoData(TelcoRequest request) throws JsonProcessingException {
        String path = "/api/v1/ussds/telcos/data";
        String body =  mapper.writeValueAsString(request);
        Message message = generateHMAC(path, body);
        return client.retrieveTelco(request, message.getTimeStamp(), message.getSignature());
    }

    public Object balanceInquiry(SignUpOnlineRequest request) throws JsonProcessingException {
        String path = "/api/v1/ussds/transfer/account/balance/inquiry";
        String body = mapper.writeValueAsString(request);
        Message message = generateHMAC(path, body);
        return client.balanceInquiry(request, message.getTimeStamp(), message.getSignature());
    }

    public Object airtimeRecharge(SignUpOnlineRequest request) throws JsonProcessingException {
        String path = "/api/v1/ussds/telcos/transactions/airtime";
        String body = mapper.writeValueAsString(request);
        Message message = generateHMAC(path, body);
        return client.airtimeRecharge(request, message.getTimeStamp(), message.getSignature());
    }

    public Object getSavedCards(SignUpOnlineRequest request) throws JsonProcessingException {
        String path = "/api/v1/ussds/consumers/cards";
        String body = mapper.writeValueAsString(request);
        Message message = generateHMAC(path, body);
        return client.getSaved(request, message.getTimeStamp(), message.getSignature());
    }


    public Object history(SignUpOnlineRequest request) throws JsonProcessingException {
        String path = "/api/v1/ussds/consumers/transactionHistory";
        String body = mapper.writeValueAsString(request);
        Message message = generateHMAC(path, body);
        return client.history(request, message.getTimeStamp(), message.getSignature());
    }

    public Object profile(SignUpOnlineRequest request) throws JsonProcessingException {
        String path = "/api/v1/ussds/consumers/userProfile";
        String body = mapper.writeValueAsString(request);
        Message message = generateHMAC(path, body);
        return client.userProfile(request, message.getTimeStamp(), message.getSignature());
    }

    public Object billers(SignUpOnlineRequest request) throws JsonProcessingException {
        String path = "/api/v1/ussds/billers";
        String body = mapper.writeValueAsString(request);
        Message message = generateHMAC(path, body);
        return client.getBillers(request, message.getTimeStamp(), message.getSignature());
    }
    public Object billersCategories(SignUpOnlineRequest request) throws JsonProcessingException {
        String path = "/api/v1/ussds/billers/billercategories";
        String body = mapper.writeValueAsString(request);
        Message message = generateHMAC(path, body);
        return client.getBillerCategories(request, message.getTimeStamp(), message.getSignature());
    }

    public Object billersItems(SignUpOnlineRequest request) throws JsonProcessingException {
        String path = "/api/v1/ussds/billers/billeritems";
        String body = mapper.writeValueAsString(request);
        Message message = generateHMAC(path, body);
        return client.getBillerItems(request, message.getTimeStamp(), message.getSignature());
    }

    public Object transfer(SignUpOnlineRequest request) throws JsonProcessingException {
        String path = "/api/v1/ussds/transfer/qtaccount/intitialize";
        String body = mapper.writeValueAsString(request);
        Message message = generateHMAC(path, body);
        log.info("{}", message);
        return client.transfer(request, message.getTimeStamp(), message.getSignature());
    }

    public Object transferStatus(SignUpOnlineRequest request) throws JsonProcessingException {
        String path = "/api/v1/ussds/transfer/qtaccount/status";
        String body = mapper.writeValueAsString(request);
        Message message = generateHMAC(path, body);
        log.info("{}", message);
        return client.transferStatus(request, message.getTimeStamp(), message.getSignature());
    }

    public Object gestLoan(SignUpOnlineRequest request) throws JsonProcessingException {
        String path = "/api/v1/ussds/loans/offers";
        String body = mapper.writeValueAsString(request);
        Message message = generateHMAC(path, body);
        log.info("{}", message);
        return client.getLoans(request, message.getTimeStamp(), message.getSignature());
    }

    public Object acceptLoan(SignUpOnlineRequest request) throws JsonProcessingException {
        String path = "/api/v1/ussds/loans/accept";
        String body = mapper.writeValueAsString(request);
        Message message = generateHMAC(path, body);
        log.info("{}", message);
        return client.acceptLoans(request, message.getTimeStamp(), message.getSignature());
    }

    public Object pwt(SignUpOnlineRequest request) throws JsonProcessingException {
        String path = "/api/v1/ussds/transfer/pay-with-transfer";
        String body = mapper.writeValueAsString(request);
        Message message = generateHMAC(path, body);
        log.info("{}", message);
        return client.pwt(request, message.getTimeStamp(), message.getSignature());
    }

    public Object pwtStatus(SignUpOnlineRequest request) throws JsonProcessingException {
        String path = "/api/v1/ussds/transfer/pay-with-transfer/status";
        String body = mapper.writeValueAsString(request);
        Message message = generateHMAC(path, body);
        log.info("{}", message);
        return client.pwt_status(request, message.getTimeStamp(), message.getSignature());
    }
}
