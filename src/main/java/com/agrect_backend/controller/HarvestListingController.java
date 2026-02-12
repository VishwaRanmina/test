package com.agrect_backend.controller;

import com.agrect_backend.model.HarvestListing;
import com.agrect_backend.service.HarvestListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/harvest")
public class HarvestListingController {

    @Autowired
    private HarvestListingService harvestListingService;

    @PostMapping("/add/{farmerId}/{cropId}")
    public ResponseEntity<?> addHarvestList(@PathVariable Long farmerId,
                                            @PathVariable Long cropId, @RequestBody HarvestListing harvestListing){

        try {
            HarvestListing newListing = harvestListingService.addHarvestListing(farmerId, cropId, harvestListing);
            return ResponseEntity.ok("Harvest Listed Successfully! ID: " + newListing.getId());
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/all")
    public List<HarvestListing> getAllListings(){
        return harvestListingService.getAllListings();
    }

}
