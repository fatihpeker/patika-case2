package com.example.repository;

import com.example.model.City;
import com.example.model.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepository extends JpaRepository<District,String> {
    void deleteById(String id);

    List<District> findAllByCity(City city);

}
