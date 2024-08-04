package com.Hmac.vansoMock;


import com.Hmac.vansoMock.model.SignUpOnlineRequest;
import com.Hmac.vansoMock.model.SignUpRequest;
import com.Hmac.vansoMock.model.TelcoRequest;
import com.Hmac.vansoMock.model.UssdGatewayResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

@HttpExchange(url = "/api/v1/ussds", accept = MediaType.APPLICATION_JSON_VALUE, contentType = MediaType.APPLICATION_JSON_VALUE)
public interface Client {


    @PostExchange(value = "/consumers/signup/offline")
    UssdGatewayResponse signup(@RequestBody SignUpRequest signUpRequest, @RequestHeader("TIMESTAMP") String timeStamp, @RequestHeader("SIGNATURE") String signature);

    @PostExchange(value = "/consumers/signup")
    UssdGatewayResponse signupOnline(@RequestBody SignUpOnlineRequest signUpRequest, @RequestHeader("TIMESTAMP") String timeStamp, @RequestHeader("SIGNATURE") String signature);

    @PostExchange(value = "/consumers/exist")
    UssdGatewayResponse checkExist(@RequestBody SignUpOnlineRequest request, @RequestHeader("TIMESTAMP") String timeStamp, @RequestHeader("SIGNATURE") String signature);

    @PostExchange(value = "/telcos/data")
    Object retrieveTelco(@RequestBody TelcoRequest request, @RequestHeader("TIMESTAMP") String timeStamp, @RequestHeader("SIGNATURE")String signature);

    @PostExchange(value = "/transfer/account/balance/inquiry")
    Object balanceInquiry(@RequestBody SignUpOnlineRequest request,@RequestHeader("TIMESTAMP") String timeStamp, @RequestHeader("SIGNATURE")String signature);

    @PostExchange(value = "/telcos/transactions/airtime")
    Object airtimeRecharge(@RequestBody SignUpOnlineRequest request,@RequestHeader("TIMESTAMP") String timeStamp, @RequestHeader("SIGNATURE")String signature);

    @PostExchange(value = "/transfer/qtaccount/intitialize")
    Object transfer(@RequestBody SignUpOnlineRequest request,@RequestHeader("TIMESTAMP") String timeStamp, @RequestHeader("SIGNATURE")String signature);

    @PostExchange(value = "/transfer/qtaccount/status")
    Object transferStatus(@RequestBody SignUpOnlineRequest request,@RequestHeader("TIMESTAMP") String timeStamp, @RequestHeader("SIGNATURE")String signature);
    @PostExchange(value = "/consumers/userProfile")
    Object userProfile(@RequestBody SignUpOnlineRequest request,@RequestHeader("TIMESTAMP") String timeStamp, @RequestHeader("SIGNATURE")String signature);

    @PostExchange(value = "/consumers/transactionHistory")
    Object history(@RequestBody SignUpOnlineRequest request,@RequestHeader("TIMESTAMP") String timeStamp, @RequestHeader("SIGNATURE")String signature);

    @PostExchange(value = "/consumers/cards")
    Object getSaved(@RequestBody SignUpOnlineRequest request,@RequestHeader("TIMESTAMP") String timeStamp, @RequestHeader("SIGNATURE")String signature);

    @PostExchange(value = "/billers")
    Object getBillers(@RequestBody SignUpOnlineRequest request,@RequestHeader("TIMESTAMP") String timeStamp, @RequestHeader("SIGNATURE")String signature);

    @PostExchange(value = "/billers/billercategories")
    Object getBillerCategories(@RequestBody SignUpOnlineRequest request,@RequestHeader("TIMESTAMP") String timeStamp, @RequestHeader("SIGNATURE")String signature);

    @PostExchange(value = "/billers/billeritems")
    Object getBillerItems(@RequestBody SignUpOnlineRequest request,@RequestHeader("TIMESTAMP") String timeStamp, @RequestHeader("SIGNATURE")String signature);


    @PostExchange(value = "/loans/offers")
    Object getLoans(@RequestBody SignUpOnlineRequest request,@RequestHeader("TIMESTAMP") String timeStamp, @RequestHeader("SIGNATURE")String signature);

    @PostExchange(value = "/loans/accept")
    Object acceptLoans(@RequestBody SignUpOnlineRequest request,@RequestHeader("TIMESTAMP") String timeStamp, @RequestHeader("SIGNATURE")String signature);

    @PostExchange(value = "/transfer/pay-with-transfer")
    Object pwt(@RequestBody SignUpOnlineRequest request,@RequestHeader("TIMESTAMP") String timeStamp, @RequestHeader("SIGNATURE")String signature);

    @PostExchange(value = "/transfer/pay-with-transfer/status")
    Object pwt_status(@RequestBody SignUpOnlineRequest request,@RequestHeader("TIMESTAMP") String timeStamp, @RequestHeader("SIGNATURE")String signature);


}
