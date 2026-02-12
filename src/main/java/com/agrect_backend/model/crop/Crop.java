package com.agrect_backend.model.crop;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "crops")
@Getter
@Setter
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,unique = true)
    private Long id;

    private String nameEn; // English Name (e.g., "Carrot")
    private String nameSi; // Sinhala Name (e.g., "කැරට්")

    private Integer growthDurationDays;


    @Column(nullable = false)
    private String category;


}
