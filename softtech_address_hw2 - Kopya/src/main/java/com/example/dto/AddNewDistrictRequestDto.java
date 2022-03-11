package com.example.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddNewDistrictRequestDto {

    @NotNull
    private String name;

    @NotNull
    private String city_id;

}
