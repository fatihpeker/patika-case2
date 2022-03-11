package com.example.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddNewStreetRequestDto {

    @NotNull
    private String name;

    @NotNull
    private String neigbourhood_id;

}
