package com.agrect_backend.controller;

import com.agrect_backend.model.crop.Crop;
import com.agrect_backend.service.CropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crop")
public class CropController {

    @Autowired
    private CropService cropService;

    @PostMapping("/add")
    public ResponseEntity<?> addNewCrop(@RequestBody Crop crop){
        try{
            Crop newCrop = cropService.addCrop(crop);
            return ResponseEntity.ok("Successfully Added new crop");
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/all")
    public List<Crop> getAllCrops() {
        return cropService.getAllCrops();
    }

}
