package com.agrect_backend.model.user;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "farmers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Farmer extends User {

    private String nicNo;

    private Double landAreaAcres;

    private String nearestTown;


    private String preferredCrops;
}