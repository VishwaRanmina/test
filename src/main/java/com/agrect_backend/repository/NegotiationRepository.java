package com.agrect_backend.repository;

import com.agrect_backend.model.Negotiation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NegotiationRepository extends JpaRepository<Negotiation, Long> {

    List<Negotiation> findByFarmerId(Long id);
    List<Negotiation> findBuyerById(Long id);
    List<Negotiation> findByListingId(Long listingId);
}
