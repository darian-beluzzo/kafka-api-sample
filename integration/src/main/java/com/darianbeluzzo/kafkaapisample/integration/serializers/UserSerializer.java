package com.darianbeluzzo.kafkaapisample.integration.serializers;

import com.darianbeluzzo.kafkaapisample.integration.dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

public class UserSerializer implements Serializer<UserDto> {

    @Override
    public byte[] serialize(String arg0, UserDto arg1) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retVal = objectMapper.writeValueAsString(arg1).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }

}
