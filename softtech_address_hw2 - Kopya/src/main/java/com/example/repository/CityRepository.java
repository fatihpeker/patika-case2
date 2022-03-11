package com.example.repository;

import com.example.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,String> {
    void deleteById(String id);

    City findByNumberPlate(int number_plate);
}
