package com.example.converter;

import com.example.dto.AddNewAdreessRequestDto;
import com.example.dto.AdreessResponseDto;
import com.example.model.Address;
import com.example.repository.AddressRepository;
import com.example.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddressConverter {

    private final AddressRepository addressRepository;

    private final CountryService countryService;

    private final CityService cityService;

    private final DistrictService districtService;

    private final NeigbourhoodService neigbourhoodService;

    private final StreetService streetService;

    public Address addressRequestToAddress(AddNewAdreessRequestDto addNewAdreessRequestDto){
        Address address = Address.builder()
                .buildingNumber(addNewAdreessRequestDto.getBuildingNumber())
                .doorNumber(addNewAdreessRequestDto.getDoorNumber())
                .country(countryService.getCountryById(addNewAdreessRequestDto.getCountry_id()))
                .city(cityService.getCityById(addNewAdreessRequestDto.getCity_id()))
                .district(districtService.getDistrictById(addNewAdreessRequestDto.getDistrict_id()))
                .neigbourhood(neigbourhoodService.getNeigbourhoodById(addNewAdreessRequestDto.getNeigbourhood_id()))
                .street(streetService.getStreetById(addNewAdreessRequestDto.getStreet_id()))
                .build();
        return address;
    }

    public AdreessResponseDto addressToAddressResponseDto(Address address){
        AdreessResponseDto adreessResponseDto = AdreessResponseDto.builder()
                .id(address.getAddress_id())
                .buildingNumber(address.getBuildingNumber())
                .doorNumber(address.getDoorNumber())
                .country(address.getCountry())
                .city(address.getCity())
                .district(address.getDistrict())
                .neigbourhood(address.getNeigbourhood())
                .street(address.getStreet())
                .build();
        return adreessResponseDto;
    }

}
