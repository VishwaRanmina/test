package com.agrect_backend.repository;

import com.agrect_backend.model.HarvestListing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HarvestListingRepository extends JpaRepository<HarvestListing , Long> {

    List<HarvestListing> findByFarmerId(Long farmer_id);

}
