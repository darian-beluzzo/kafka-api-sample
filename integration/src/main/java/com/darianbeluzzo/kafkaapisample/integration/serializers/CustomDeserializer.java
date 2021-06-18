package com.darianbeluzzo.kafkaapisample.integration.serializers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

public class CustomDeserializer implements Deserializer<Object> {

    private final Logger logger = LoggerFactory.getLogger(CustomDeserializer.class);

    @Override
    public Object deserialize(String topic, Headers headers, byte[] data) {
        Header header = headers.lastHeader(CustomSerializer.SERIALIZER_CLASS);
        String strClass = new String(header.value(), StandardCharsets.UTF_8);
        Class<?> clazz;
        try {
            clazz = Class.forName(strClass);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        ObjectMapper mapper = new ObjectMapper();
        Object value = null;
        try {
            value = mapper.readValue(data, clazz);
        } catch (Exception e) {
            logger.info("Cannot convert data to class {}", clazz);
        }
        return value;
    }

    @Override
    public Object deserialize(String topic, byte[] data) {
        return null;
    }

}