package com.dev.ryan.TurismClean.infra.persistence;

import com.dev.ryan.TurismClean.core.enums.TurismType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "turism")

public class TravelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String identifier;
    @Column(name = "turism_start")
    private LocalDateTime turismStart;
    @Column(name = "turism_end")
    private LocalDateTime turismEnd;
    private String localization;
    private Integer capacity;
    private String enterprise;

    @Enumerated(EnumType.STRING)
    private TurismType type;
}

