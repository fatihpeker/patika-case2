package com.example.repository;

import com.example.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CountryRepository extends JpaRepository<Country,String> {
    void deleteById(String id);

    @Query(value = "select c from Country c where c.country_code = :country_code")
    Country findCountryByCountry_code(@Param("country_code") String country_code);

}
