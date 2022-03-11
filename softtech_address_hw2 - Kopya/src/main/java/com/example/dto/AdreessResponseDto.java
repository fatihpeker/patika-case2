package com.example.dto;

import com.example.model.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AdreessResponseDto {

    private String id;

    private int buildingNumber;

    private int doorNumber;

    Country country = new Country();

    City city = new City();

    District district = new District();

    Neigbourhood neigbourhood = new Neigbourhood();

    Street street = new Street();

}
