package com.example.controller;

import com.example.dto.AddNewCityRequestDto;
import com.example.dto.AddNewDistrictRequestDto;
import com.example.dto.AddNewNeigbourhoodRequestDto;
import com.example.dto.AddNewStreetRequestDto;
import com.example.model.Country;
import com.example.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/admin")
public class Admincontroller {

    private final CountryService countryService;

    private final CityService cityService;

    private final DistrictService districtService;

    private final StreetService streetService;

    private final NeigbourhoodService neigbourhoodService;


    //FOR COUNTRY
    @PostMapping("addCountry")
    public ResponseEntity addNewCountry(@Valid @RequestBody Country country){
        return new ResponseEntity<>(countryService.addNewCountry(country),HttpStatus.CREATED);
    }

    @DeleteMapping("deleteCountry")
    public ResponseEntity deleteCountry(@RequestParam String id){
        countryService.deleteCountry(id);
        return ResponseEntity.ok(Void.TYPE);
    }

    //FOR CITY
    @PostMapping("addCity")
    public ResponseEntity addNewCity(@RequestBody AddNewCityRequestDto addNewCityRequestDto){
        return new ResponseEntity<>(cityService.addNewCity(addNewCityRequestDto),HttpStatus.CREATED);
    }

    @DeleteMapping("deleteCity")
    public ResponseEntity deleteCity(@RequestParam String id){
        cityService.deleteCity(id);
        return ResponseEntity.ok(Void.TYPE);
    }

    //FOR DISTRICT
    @PostMapping("addDistrict")
    public ResponseEntity addNewDistrict(@Valid @RequestBody AddNewDistrictRequestDto addNewDistrictRequestDto){
        return new ResponseEntity<>(districtService.addNewDistrict(addNewDistrictRequestDto),HttpStatus.CREATED);
    }
    @DeleteMapping("deleteDistrict")
    public ResponseEntity deleteDistrict(@RequestParam String id){
        districtService.deleteDistrict(id);
        return ResponseEntity.ok(Void.TYPE);
    }

    //FOR NEIGBOURHOOD
    @PostMapping("addNeigbourhood")
    public ResponseEntity addNewNeigbourhood(@Valid @RequestBody AddNewNeigbourhoodRequestDto addNewNeigbourhoodRequestDto){
        return new ResponseEntity<>(neigbourhoodService.addNewNeigbourhood(addNewNeigbourhoodRequestDto),HttpStatus.CREATED);
    }

    @DeleteMapping("deleteNeigbourhood")
    public ResponseEntity deleteNeigbourhood(@RequestParam String id){
        neigbourhoodService.deleteNeigbourhood(id);
        return ResponseEntity.ok(Void.TYPE);
    }

    @PutMapping("updateNeigbourhood")
    public ResponseEntity updateNeigbourHoodName(@RequestParam String neigbourhood_id, @RequestParam String name){
        return new ResponseEntity<>(neigbourhoodService.updateNeigbourhoodName(neigbourhood_id,name),HttpStatus.CREATED);
    }

    //FOR STREET
    @PostMapping("addStreet")
    public ResponseEntity addNewStreet(@Valid @RequestBody AddNewStreetRequestDto addNewStreetRequestDto){
        return new ResponseEntity(streetService.addNewStreet(addNewStreetRequestDto), HttpStatus.CREATED);
    }

    @DeleteMapping("deleteStreet")
    public ResponseEntity deleteStreet(@RequestParam String id){
        streetService.deleteStreet(id);
        return ResponseEntity.ok(Void.TYPE);
    }

    @PutMapping("updateStreet")
    public ResponseEntity updateStreetName(@RequestParam String street_id,@RequestParam String name){
        return new ResponseEntity<>(streetService.updateStreetName(street_id,name),HttpStatus.CREATED);
    }




}
