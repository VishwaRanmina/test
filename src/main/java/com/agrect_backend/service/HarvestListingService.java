package com.agrect_backend.service;

import com.agrect_backend.model.HarvestListing;
import com.agrect_backend.model.crop.Crop;
import com.agrect_backend.model.user.User;
import com.agrect_backend.repository.CropRepository;
import com.agrect_backend.repository.HarvestListingRepository;
import com.agrect_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HarvestListingService {

    @Autowired
    private HarvestListingRepository harvestListingRepository;

    @Autowired
    private CropRepository cropRepository;

    @Autowired
    private UserRepository userRepository;

    public HarvestListing addHarvestListing(Long farmer_id , Long crop_id , HarvestListing harvestListing) {

        User farmer  = userRepository.findById(farmer_id).orElseThrow(()-> new
        RuntimeException("Farmer not found"));
        Crop crop = cropRepository.findById(crop_id).orElseThrow(()-> new RuntimeException("Crop not found"));

        harvestListing.setFarmer(farmer);
        harvestListing.setCrop(crop);

        return harvestListingRepository.save(harvestListing);

    }
    public List<HarvestListing> getAllListings() {
        return harvestListingRepository.findAll();
    }

}
