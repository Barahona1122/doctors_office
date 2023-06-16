package com.example.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.OfficesModel;
import com.example.demo.repository.OfficesRepository;

@Service
public class OfficiesService {

    @Autowired
    OfficesRepository officesRepository;

    /**
     * @return
     */
    public ArrayList<OfficesModel> findAll() {
        return (ArrayList<OfficesModel>) officesRepository.findAll();
    }

    /**
     * @param officesModel
     * @return
     */
    public OfficesModel save(OfficesModel officesModel) {
        return officesRepository.save(officesModel);
    }

    /**
     * @param name
     * @return
     */
    public ArrayList<OfficesModel> findByFloorName(String name) {
        return (ArrayList<OfficesModel>) officesRepository.findByFloorName(name);
    }

}
