package com.agrect_backend.model.user;

import com.agrect_backend.model.enums.ServiceType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "service_providers")
@PrimaryKeyJoinColumn(name = "user_id")
public class ServiceProvider extends User {

    @Enumerated(EnumType.STRING)
    private ServiceType serviceCategory;

    private String vehicleNumber;

    private Double ratePerUnit;

    private String baseLocation;
}