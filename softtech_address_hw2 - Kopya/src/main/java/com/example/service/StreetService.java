package com.example.service;

import com.example.dto.AddNewStreetRequestDto;
import com.example.model.Neigbourhood;
import com.example.model.Street;
import com.example.repository.StreetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StreetService {

    private final StreetRepository streetRepository;

    private final NeigbourhoodService neigbourhoodService;


    public Street addNewStreet(AddNewStreetRequestDto addNewStreetRequestDto){
        Neigbourhood neigbourhood = neigbourhoodService.getNeigbourhoodById(addNewStreetRequestDto.getNeigbourhood_id());
        Street street = Street.builder()
                .name(addNewStreetRequestDto.getName())
                .neigbourhood(neigbourhood)
                .build();
        return streetRepository.save(street);
    }

    //id ile delete
    public void deleteStreet(String id){
        streetRepository.deleteById(id);
    }

    public Street updateStreetName(String street_id, String name){
        Street street = streetRepository.getById(street_id);
        street.setName(name);
        return street;
    }

    public Street getStreetById(String id){
        return streetRepository.getById(id);
    }

    public List<Street> getStreetByNeigbourhood(String neigbourhood_id){
        return streetRepository.findAllByNeigbourhood(neigbourhoodService.getNeigbourhoodById(neigbourhood_id));
    }

}
