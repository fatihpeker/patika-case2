package com.example.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddNewCityRequestDto {

    @NotNull
    private String name;

    @NotNull
    private int number_plate;

    @NotNull
    private String country_id;

}
