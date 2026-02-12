package com.agrect_backend.repository;

import com.agrect_backend.model.crop.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CropRepository extends JpaRepository<Crop , Long> {

    @Override
    Optional<Crop> findById(Long aLong);
}
