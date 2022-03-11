package com.example.repository;

import com.example.model.Neigbourhood;
import com.example.model.Street;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StreetRepository extends JpaRepository<Street,String> {
    void deleteById(String id);

    List<Street> findAllByNeigbourhood(Neigbourhood neigbourhood);
}
