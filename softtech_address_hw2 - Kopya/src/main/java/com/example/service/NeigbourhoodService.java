package com.example.service;

import com.example.dto.AddNewNeigbourhoodRequestDto;
import com.example.model.District;
import com.example.model.Neigbourhood;
import com.example.repository.NeigbourhoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NeigbourhoodService {

    private final NeigbourhoodRepository neigbourhoodRepository;

    private final DistrictService districtService;


    public Neigbourhood addNewNeigbourhood(AddNewNeigbourhoodRequestDto addNewNeigbourhoodRequestDto){
        District district = districtService.getDistrictById(addNewNeigbourhoodRequestDto.getDistrict_id());
        Neigbourhood neigbourhood = Neigbourhood.builder()
                .name(addNewNeigbourhoodRequestDto.getName())
                .district(district)
                .build();
        return neigbourhoodRepository.save(neigbourhood);
    }

    //id ile delete
    public void deleteNeigbourhood(String id){
        neigbourhoodRepository.deleteById(id);
    }

    public Neigbourhood updateNeigbourhoodName(String neigbourhood_id,String name){
        Neigbourhood neigbourhood = neigbourhoodRepository.getById(neigbourhood_id);
        neigbourhood.setName(name);
        return neigbourhoodRepository.save(neigbourhood);
    }

    public Neigbourhood getNeigbourhoodById(String id){
        return neigbourhoodRepository.getById(id);
    }

    public List<Neigbourhood> getNeigbourhoodByDistrict(String district_id){
        return neigbourhoodRepository.findAllByDistrict(districtService.getDistrictById(district_id));
    }

}
