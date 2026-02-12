package com.agrect_backend.model.user;

import com.agrect_backend.model.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true, nullable = false)
    private String phone;

    private String password;

    private String address;

    private String district;

    private Double latitude;
    private Double longitude;

    private String profileImageUrl;

    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}