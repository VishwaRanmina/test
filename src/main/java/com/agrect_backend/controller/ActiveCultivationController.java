package com.agrect_backend.controller;

import com.agrect_backend.model.ActiveCultivation;
import com.agrect_backend.service.ActiveCultivationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cultivation")
public class ActiveCultivationController {

    @Autowired
    private ActiveCultivationService activeCultivationService;

    @PostMapping("/add/{farmerId}/{cropId}")
    public ResponseEntity<?> new_list(
            @PathVariable Long farmerId,
            @PathVariable Long cropId,
            @RequestBody ActiveCultivation cultivation
    ) {
        try {
            // Service එකට මේ තුනම යවනවා
            ActiveCultivation newList = activeCultivationService.addCultivation(farmerId, cropId, cultivation);
            return ResponseEntity.ok("List Added Successfully! ID: " + newList.getId());

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
