package com.agrect_backend.controller;

import com.agrect_backend.model.BuyerRequirement;
import com.agrect_backend.service.BuyerRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buyer-requirement")
public class BuyerRequirementsController {

    @Autowired
    private BuyerRequirementService buyerRequirementService;

    @PostMapping("/add")
    public ResponseEntity<?> addBuyerRequirement(@RequestParam Long buyer_id,
                                                 @RequestParam Long crop_id,
                                                 @RequestBody BuyerRequirement buyerRequirement
    ){
        try{

            BuyerRequirement newRequirement = buyerRequirementService.addBuyerRequirement(buyer_id,crop_id,buyerRequirement);
            return ResponseEntity.ok("Requirement Added Successfully!");


        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping("/all")
    public List<BuyerRequirement> getAllRequirements(){
        return buyerRequirementService.allBuyerRequirements();
    }

}
