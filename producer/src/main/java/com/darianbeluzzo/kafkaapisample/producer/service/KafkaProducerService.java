package com.darianbeluzzo.kafkaapisample.producer.service;

import com.darianbeluzzo.kafkaapisample.integration.dto.UserDto;
import com.darianbeluzzo.kafkaapisample.integration.serializers.CustomSerializer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class KafkaProducerService {

    @Value("${spring.kafka.producer.topic}")
    private String producerTopic;

    private final KafkaTemplate<String, UserDto> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, UserDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(final UserDto user){
        ProducerRecord<String, UserDto> message = new ProducerRecord<>(producerTopic, user);
        message.headers().add(CustomSerializer.SERIALIZER_CLASS, UserDto.class.getName().getBytes(StandardCharsets.UTF_8));
        this.kafkaTemplate.send(message);
    }
}
