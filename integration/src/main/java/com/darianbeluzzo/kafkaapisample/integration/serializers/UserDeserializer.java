package com.darianbeluzzo.kafkaapisample.integration.serializers;

import com.darianbeluzzo.kafkaapisample.integration.dto.UserDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

public class UserDeserializer implements Deserializer<UserDto> {

    @Override
    public UserDto deserialize(String arg0, byte[] arg1) {
        ObjectMapper mapper = new ObjectMapper();
        UserDto user = null;
        try {
            user = mapper.readValue(arg1, UserDto.class);
        } catch (Exception e) {

            e.printStackTrace();
        }
        return user;
    }

}