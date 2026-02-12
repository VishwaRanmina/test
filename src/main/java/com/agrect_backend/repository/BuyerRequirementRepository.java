package com.agrect_backend.repository;

import com.agrect_backend.model.BuyerRequirement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuyerRequirementRepository extends JpaRepository<BuyerRequirement , Long> {

    List<BuyerRequirement> findByBuyerId(Long buyer_id);
    List<BuyerRequirement> findByCropId(Long cropId);

}
