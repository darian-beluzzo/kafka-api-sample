package com.darianbeluzzo.kafkaapisample.producer.controller;

import com.darianbeluzzo.kafkaapisample.integration.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Tag(name = "Kafka Producer", description = "Endpoint for producing message to broker")
public interface KafkaProducer {

    @Operation(summary = "Send message", description = "Send message to kafka broker", tags = { "UserDto" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Message delivered"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "422", description = "Unprocessable Entity"),
            @ApiResponse(responseCode = "500", description = "Message couldn't be delivered")
    })
    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<?> sendMessage(@RequestBody @Valid UserDto userDto);
}
