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
}
