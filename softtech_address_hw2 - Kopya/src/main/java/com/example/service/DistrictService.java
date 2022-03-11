package com.example.service;

import com.example.dto.AddNewDistrictRequestDto;
import com.example.model.City;
import com.example.model.District;
import com.example.repository.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class DistrictService {

    private final DistrictRepository districtRepository;

    private final CityService cityService;


    public District addNewDistrict(AddNewDistrictRequestDto addNewDistrictRequestDto){
        City city = cityService.getCityById(addNewDistrictRequestDto.getCity_id());
        District district = District.builder()
                .name(addNewDistrictRequestDto.getName())
                .city(city)
                .build();
        return districtRepository.save(district);
    }

    //id ile delete
    public void deleteDistrict(String id){
        districtRepository.deleteById(id);
    }

    public District getDistrictById(String id){
        return districtRepository.getById(id);
    }

    public List<District> getDistrictsByCity(String city_id){
        return districtRepository.findAllByCity(cityService.getCityById(city_id));
    }

}
