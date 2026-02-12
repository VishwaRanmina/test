package com.agrect_backend.model;

import com.agrect_backend.model.user.User;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "negotiation_logs")
@Data
public class NegotiationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "negotiation_id", nullable = false)
    private Negotiation negotiation;

    @ManyToOne
    @JoinColumn(name = "offered_by_id", nullable = false)
    private User offeredBy;

    private Double price;
    private String message;

    private LocalDateTime timestamp = LocalDateTime.now();
}