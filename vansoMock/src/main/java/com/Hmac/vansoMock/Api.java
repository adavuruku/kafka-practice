package com.Hmac.vansoMock;


import com.Hmac.vansoMock.model.SignUpOnlineRequest;
import com.Hmac.vansoMock.model.SignUpRequest;
import com.Hmac.vansoMock.model.TelcoRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Slf4j
public class Api {
    private final HmacService service;


    @PostMapping("/vanso/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest request) throws JsonProcessingException {
        return new ResponseEntity<>(service.signupUser(request), HttpStatus.OK);
    }

    @PostMapping("/vanso/signup-nin")
    public ResponseEntity<?> signUpNIN(@RequestBody SignUpOnlineRequest request) throws JsonProcessingException {
        return new ResponseEntity<>(service.signUpOnline(request), HttpStatus.OK);
    }

    @PostMapping("/vanso/exist")
    public ResponseEntity<?> consumerExists(@RequestBody SignUpOnlineRequest request) throws JsonProcessingException {
        return new ResponseEntity<>(service.exists(request), HttpStatus.OK);
    }

    @PostMapping("/vanso/user-profile")
    public ResponseEntity<?> userProfile(@RequestBody SignUpOnlineRequest request) throws JsonProcessingException {
        return new ResponseEntity<>(service.profile(request), HttpStatus.OK);
    }

    @PostMapping("/vanso/telco")
    public ResponseEntity<?> telco(@RequestBody TelcoRequest request) throws JsonProcessingException {
        return new ResponseEntity<>(service.telcoData(request), HttpStatus.OK);
    }

    @PostMapping("/vanso/transfer/balance")
    public ResponseEntity<?> transferInquiry(@RequestBody SignUpOnlineRequest request) throws JsonProcessingException {
        return new ResponseEntity<>(service.balanceInquiry(request), HttpStatus.OK);
    }

    @PostMapping("/vanso/airtime")
    public ResponseEntity<?> airtime(@RequestBody SignUpOnlineRequest request) throws JsonProcessingException {
        return new ResponseEntity<>(service.airtimeRecharge(request), HttpStatus.OK);
    }

    @PostMapping("/vanso/transfer")
    public ResponseEntity<?> transfer(@RequestBody SignUpOnlineRequest request) throws JsonProcessingException {
        return new ResponseEntity<>(service.transfer(request), HttpStatus.OK);
    }

    @PostMapping("/vanso/transfer/status")
    public ResponseEntity<?> transferStatus(@RequestBody SignUpOnlineRequest request) throws JsonProcessingException {
        return new ResponseEntity<>(service.transferStatus(request), HttpStatus.OK);
    }


    @PostMapping("/vanso/transactionHistory")
    public ResponseEntity<?> history(@RequestBody SignUpOnlineRequest request) throws JsonProcessingException {
        return new ResponseEntity<>(service.history(request), HttpStatus.OK);
    }

    @PostMapping("/vanso/getSaved")
    public ResponseEntity<?> getSaved(@RequestBody SignUpOnlineRequest request) throws JsonProcessingException {
        return new ResponseEntity<>(service.getSavedCards(request), HttpStatus.OK);
    }

    @PostMapping("/vanso/getBillers")
    public ResponseEntity<?> getBillers(@RequestBody SignUpOnlineRequest request) throws JsonProcessingException {
        return new ResponseEntity<>(service.billers(request), HttpStatus.OK);
    }
    @PostMapping("/vanso/getBillersItems")
    public ResponseEntity<?> getBillersItems(@RequestBody SignUpOnlineRequest request) throws JsonProcessingException {
        return new ResponseEntity<>(service.billersItems(request), HttpStatus.OK);
    }

    @PostMapping("/vanso/getBillers-cat")
    public ResponseEntity<?> getBillersCategories(@RequestBody SignUpOnlineRequest request) throws JsonProcessingException {
        return new ResponseEntity<>(service.billersCategories(request), HttpStatus.OK);
    }

    @PostMapping("/vanso/loans/offers")
    public ResponseEntity<?> getLoans(@RequestBody SignUpOnlineRequest request) throws JsonProcessingException {
        return new ResponseEntity<>(service.gestLoan(request), HttpStatus.OK);
    }

    @PostMapping("/vanso/loans/accept")
    public ResponseEntity<?> acceptLoans(@RequestBody SignUpOnlineRequest request) throws JsonProcessingException {
        return new ResponseEntity<>(service.acceptLoan(request), HttpStatus.OK);
    }

    @PostMapping("/vanso/transfer/pwt")
    public ResponseEntity<?> pwt(@RequestBody SignUpOnlineRequest request) throws JsonProcessingException {
        return new ResponseEntity<>(service.pwt(request), HttpStatus.OK);
    }

    @PostMapping("/vanso/transfer/pwt/status")
    public ResponseEntity<?> pwt_status(@RequestBody SignUpOnlineRequest request) throws JsonProcessingException {
        return new ResponseEntity<>(service.pwtStatus(request), HttpStatus.OK);
    }
}
