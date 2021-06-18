package com.darianbeluzzo.kafkaapisample.producer.controller;

import com.darianbeluzzo.kafkaapisample.integration.dto.UserDto;
import com.darianbeluzzo.kafkaapisample.producer.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "producer")
public class KafkaProducerController implements KafkaProducer {

    @Autowired
    private KafkaProducerService producer;

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody @Valid UserDto userDto) {
        try {
            producer.send(userDto);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
