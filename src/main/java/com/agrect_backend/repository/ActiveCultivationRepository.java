package com.agrect_backend.repository;

import com.agrect_backend.model.ActiveCultivation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ActiveCultivationRepository extends JpaRepository<ActiveCultivation ,Long> {
    List<ActiveCultivation> findByFarmerId(Long farmerId);
}
