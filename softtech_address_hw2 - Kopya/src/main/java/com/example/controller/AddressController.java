package com.example.controller;

import com.example.dto.AddNewAdreessRequestDto;
import com.example.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/address")
public class AddressController {

    private final AddressService addressService;

    private final CountryService countryService;

    private final CityService cityService;

    private final DistrictService districtService;

    private final NeigbourhoodService neigbourhoodService;

    private final StreetService streetService;


    @PostMapping("addAddresss")
    public ResponseEntity addNewAddress(@Valid @RequestBody AddNewAdreessRequestDto addNewAdreessRequestDto){
        return new ResponseEntity<>(addressService.addnewAddreess(addNewAdreessRequestDto),HttpStatus.CREATED);
    }

    //id ile delete işlemi
    @DeleteMapping("deleteAddress")
    public ResponseEntity deleteAddress(@RequestParam String address_id){
        addressService.deleteAddress(address_id);
        return ResponseEntity.ok(Void.TYPE);
    }

    @GetMapping("getAddress")
    public ResponseEntity getAddress(@RequestParam String address_id){
        return new ResponseEntity<>(addressService.getAddress(address_id),HttpStatus.OK);
    }

    @GetMapping("getContry")
    public ResponseEntity getCountryByCountryCode(@RequestParam String country_code){
        return new ResponseEntity<>(countryService.getCountryByCountryCode(country_code),HttpStatus.OK);
    }

    @GetMapping("getCity")
    public ResponseEntity getCityByNumberPlate(@RequestParam int number_plate){
        return new ResponseEntity<>(cityService.getCityByNumberPlate(number_plate),HttpStatus.OK);
    }

    @GetMapping("getDistrict")
    public ResponseEntity getDistrictsByCity(@RequestParam String city_id){
        return new ResponseEntity<>(districtService.getDistrictsByCity(city_id),HttpStatus.OK);
    }

    @GetMapping("getNeigbourhood")
    public ResponseEntity getNeigBourhoodsByDistrict(@RequestParam String district_id){
        return new ResponseEntity<>(neigbourhoodService.getNeigbourhoodByDistrict(district_id),HttpStatus.OK);
    }

    @GetMapping("getStreets")
    public ResponseEntity getStreetsByNeigbourhood(@RequestParam String neigbourhood_id){
        return new ResponseEntity<>(streetService.getStreetByNeigbourhood(neigbourhood_id),HttpStatus.OK);
    }

}
