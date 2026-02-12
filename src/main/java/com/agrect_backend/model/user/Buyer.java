package com.agrect_backend.model.user;

import com.agrect_backend.model.enums.BuyerType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "buyers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Buyer extends User {

    private String companyName;
    private String businessRegNo;

    @Enumerated(EnumType.STRING)
    private BuyerType type; // WHOLESALE, RETAIL, EXPORTER
}