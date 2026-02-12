package com.agrect_backend.model.user;

import com.agrect_backend.model.enums.ShopType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "shops")
@PrimaryKeyJoinColumn(name = "user_id")
public class Shop extends User {

    private String shopName;
    private String openHours;

    @Enumerated(EnumType.STRING)
    private ShopType type; // FERTILIZER, SEEDS, EQUIPMENT
}