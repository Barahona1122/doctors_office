package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.OfficesModel;

@Repository
public interface OfficesRepository extends JpaRepository<OfficesModel, Long> {
    /**
     * @return
     */
    List<OfficesModel> findByFloorName(String name);
}
