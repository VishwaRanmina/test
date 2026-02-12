package com.agrect_backend.model;


import com.agrect_backend.model.crop.Crop;
import com.agrect_backend.model.enums.Status;
import com.agrect_backend.model.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "buyer_requirement")
public class BuyerRequirement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "crop_id",nullable = false)
    private Crop crop;

    @ManyToOne
    @JoinColumn(name = "buyer_id",nullable = false)
    private User buyer;

    @Column(nullable = false)
    private Double quantityNeededKg;

    @Column(nullable = false)
    private Double targetPricePerKg;

    @Column(nullable = false)
    private Double deadline;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;
}
