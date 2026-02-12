package com.agrect_backend.model;


import com.agrect_backend.model.crop.Crop;
import com.agrect_backend.model.enums.Grade;
import com.agrect_backend.model.enums.Status;
import com.agrect_backend.model.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "harvest_listing")
public class HarvestListing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "farmer_id", nullable = false)
    private User farmer;

    @ManyToOne
    @JoinColumn(name = "crop_id", nullable = false)
    private Crop crop;

    @Column(nullable = false)
    private Double quantityKg;

    @Column(nullable = false)
    private Double pricePerKg;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Grade qualityGrade;

    private String imageUrl;

    @Column(nullable = false)
    private LocalDate expiryDate;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.AVAILABLE;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();



}
