package com.example.service;

import com.example.converter.AddressMapper;
import com.example.converter.AddressConverter;
import com.example.dto.AddNewAdreessRequestDto;
import com.example.dto.AdreessResponseDto;
import com.example.model.Address;
import com.example.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AddressService {

    private final AddressRepository addressRepository;

    private final CountryService countryService;

    private final CityService cityService;

    private final DistrictService districtService;

    private final NeigbourhoodService neigbourhoodService;

    private final StreetService streetService;

    private final AddressConverter addressConverter;

    public AdreessResponseDto addnewAddreess(AddNewAdreessRequestDto addNewAdreessRequestDto){
        Address address = addressConverter.addressRequestToAddress(addNewAdreessRequestDto);
        addressRepository.save(address);
        AdreessResponseDto adreessResponseDto = addressConverter.addressToAddressResponseDto(address);
        return adreessResponseDto;
    }

    //id ile delete
    public void deleteAddress(String address_id){
        addressRepository.deleteById(address_id);
    }

    public AdreessResponseDto getAddress(String address_id){
        Address address = addressRepository.getById(address_id);
        AdreessResponseDto adreessResponseDto = addressConverter.addressToAddressResponseDto(address);
        return adreessResponseDto;
    }

}
