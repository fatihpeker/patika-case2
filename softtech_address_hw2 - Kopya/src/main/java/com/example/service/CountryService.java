package com.example.service;

import com.example.model.Country;
import com.example.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public Country addNewCountry(Country country){
        return countryRepository.save(country);
    }

    //id ile delete
    public void deleteCountry(String id){
        countryRepository.deleteById(id);
    }

    public Country getCountryById(String id){
        return countryRepository.getById(id);
    }

    public Country getCountryByCountryCode(String country_code){
        return countryRepository.findCountryByCountry_code(country_code);
    }

}
