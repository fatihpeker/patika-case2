package com.example.repository;

import com.example.model.District;
import com.example.model.Neigbourhood;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NeigbourhoodRepository extends JpaRepository<Neigbourhood,String> {
    void deleteById(String id);

    List<Neigbourhood> findAllByDistrict(District district);
}
