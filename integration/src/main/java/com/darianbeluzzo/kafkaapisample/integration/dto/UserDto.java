package com.darianbeluzzo.kafkaapisample.integration.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {

    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotNull(message = "Age is mandatory")
    private Integer age;

}