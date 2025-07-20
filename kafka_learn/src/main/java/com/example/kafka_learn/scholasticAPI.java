package com.example.kafka_learn;

import com.example.kafka_learn.dto.scholastic.district.CreateDistrict;
import com.example.kafka_learn.dto.scholastic.user.CreateUser;
import com.example.kafka_learn.service.ScholasticProducerService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static org.springframework.http.HttpStatus.CREATED;

/**
 * Created by Sherif.Abdulraheem 8/3/2024 - 8:34 PM
 **/
@RequestMapping("/api/v1/scholastic")
@RequiredArgsConstructor
@RestController
public class scholasticAPI {
    private final ScholasticProducerService scholasticProducerService;

    @PostMapping("/send")
    public ResponseEntity<Object> stringMessage(
            @RequestBody @Validated Object dataObj, HttpServletRequest httpServletRequest)
            throws IOException {
        scholasticProducerService.sendJson(dataObj);
        return new ResponseEntity<>("Successful", CREATED);
    }

    @PostMapping("/send2")
    public ResponseEntity<Object> stringMessageTwo(
            @RequestBody @Validated Object dataObj, HttpServletRequest httpServletRequest)
            throws IOException {
        scholasticProducerService.sendJson2(dataObj);
        return new ResponseEntity<>("Successful", CREATED);
    }

    @PostMapping("/cmdm/send")
    public ResponseEntity<Object> sendCMDMMessage(
            @RequestBody @Validated Object dataObj, HttpServletRequest httpServletRequest)
            throws IOException {
        scholasticProducerService.sendCMDMJson(dataObj);
        return new ResponseEntity<>("Successful", CREATED);
    }

    @PostMapping("/iam/send")
    public ResponseEntity<Object> sendIAMMessage(
            @RequestBody @Validated Object dataObj, HttpServletRequest httpServletRequest)
            throws IOException {
        scholasticProducerService.sendIamJson(dataObj);
        return new ResponseEntity<>("Successful", CREATED);
    }

    @PostMapping("/cdc/send")
    public ResponseEntity<Object> sendCDCUserMessage(
            @RequestBody @Validated Object dataObj,
            @RequestParam("topic") String topic, HttpServletRequest httpServletRequest)
            throws IOException {

//        for (int i = 0; i < 20; i++) {
//            scholasticProducerService.sendCDCUserJson(dataObj, topic);
//        }
        scholasticProducerService.sendCDCUserJson(dataObj, topic);
        return new ResponseEntity<>("Successful", CREATED);
    }

}
