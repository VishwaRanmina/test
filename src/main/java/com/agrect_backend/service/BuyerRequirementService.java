package com.agrect_backend.service;


import com.agrect_backend.model.BuyerRequirement;
import com.agrect_backend.model.crop.Crop;
import com.agrect_backend.model.user.User;
import com.agrect_backend.repository.BuyerRequirementRepository;
import com.agrect_backend.repository.CropRepository;
import com.agrect_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerRequirementService {

    @Autowired
    private BuyerRequirementRepository buyerRequirementRepository;

    @Autowired
    private CropRepository cropRepository;

    @Autowired
    private UserRepository userRepository;

    public BuyerRequirement addBuyerRequirement(Long buyer_id , Long crop_id , BuyerRequirement requirement){

        User buyer = userRepository.findById(buyer_id).orElseThrow(()-> new RuntimeException("Buyer Not found! "));
        Crop crop = cropRepository.findById(crop_id).orElseThrow(()-> new RuntimeException("Crop not found! "));

        requirement.setBuyer(buyer);
        requirement.setCrop(crop);

        return buyerRequirementRepository.save(requirement);

    }
    public List<BuyerRequirement> allBuyerRequirements(){
        return buyerRequirementRepository.findAll();
    }

}
