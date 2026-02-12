package com.agrect_backend.service;


import com.agrect_backend.model.crop.Crop;
import com.agrect_backend.repository.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CropService {

    @Autowired
    private CropRepository cropRepository;

    public Crop addCrop(Crop crop){
        return cropRepository.save(crop);
    }
    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }



}
