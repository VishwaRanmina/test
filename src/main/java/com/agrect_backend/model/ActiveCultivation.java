package com.agrect_backend.model;


import com.agrect_backend.model.crop.Crop;
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
@Table(name = "active_cultivation")
public class ActiveCultivation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "crop_id",nullable = false)
    private Crop crop;

    @ManyToOne
    @JoinColumn(name = "farmer_id",nullable = false)
    private User farmer;

    @Column(nullable = false)
    private Double landArea;

    @Column(nullable = false)
    private Double expectedQuantityKg;

    @Column(nullable = false)
    private LocalDate expectedHarvestDate;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.GROWING;
}
