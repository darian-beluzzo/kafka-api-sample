package com.darianbeluzzo.kafkaapisample.consumer.service;

import com.darianbeluzzo.kafkaapisample.integration.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = "#{'${spring.kafka.consumer.topic}'}", groupId = "#{'${spring.kafka.consumer.group-id}'}")
    public void receiveMessage(UserDto user) {
        logger.info("#### Message received -> {}", user.toString());
    }
}
