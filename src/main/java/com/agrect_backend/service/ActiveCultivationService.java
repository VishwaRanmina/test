package com.agrect_backend.service;

import com.agrect_backend.model.ActiveCultivation;
import com.agrect_backend.model.crop.Crop;
import com.agrect_backend.model.user.User;
import com.agrect_backend.repository.ActiveCultivationRepository;
import com.agrect_backend.repository.CropRepository;
import com.agrect_backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActiveCultivationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CropRepository cropRepository;

    @Autowired
    private ActiveCultivationRepository activeCultivationRepository;

    public ActiveCultivation addCultivation(Long farmerId, Long cropId, ActiveCultivation cultivation){
        User farmer = userRepository.findById(farmerId)
                .orElseThrow(() -> new RuntimeException("Farmer not found"));
        Crop crop = cropRepository.findById(cropId)
                .orElseThrow(() -> new RuntimeException("Crop not found"));

        cultivation.setFarmer(farmer);
        cultivation.setCrop(crop);

        return activeCultivationRepository.save(cultivation);
    }
    public List<ActiveCultivation> getCultivationsByFarmer(Long farmerId) {
        return activeCultivationRepository.findByFarmerId(farmerId);
    }

}
