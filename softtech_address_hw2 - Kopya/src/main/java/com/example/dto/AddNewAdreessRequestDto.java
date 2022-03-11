package com.example.dto;

import com.example.model.*;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddNewAdreessRequestDto {

    @NotNull
    private int buildingNumber;

    @NotNull
    private int doorNumber;

    @NotNull
    private String country_id;

    @NotNull
    private String city_id;

    @NotNull
    private String district_id;

    @NotNull
    private String neigbourhood_id;

    @NotNull
    private String street_id;


}
