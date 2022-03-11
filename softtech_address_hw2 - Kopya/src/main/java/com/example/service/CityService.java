package com.example.service;

import com.example.dto.AddNewCityRequestDto;
import com.example.model.City;
import com.example.model.Country;
import com.example.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class CityService {

    private final CityRepository cityRepository;

    private final CountryService countryService;


    public City addNewCity(AddNewCityRequestDto addNewCityRequestDto){
        Country country = countryService.getCountryById(addNewCityRequestDto.getCountry_id());
        City city = City.builder()
                .name(addNewCityRequestDto.getName())
                .numberPlate(addNewCityRequestDto.getNumber_plate())
                .country(country).build();
        return cityRepository.save(city);
    }

    //id ile delete
    public void deleteCity(String id){
        cityRepository.deleteById(id);
    }

    public City getCityById(String id){
        return cityRepository.getById(id);
    }

    public City getCityByNumberPlate(int number_plate){
        return cityRepository.findByNumberPlate(number_plate);
    }

}
