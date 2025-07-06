package com.dev.ryan.TurismClean.infra.dtos;

import com.dev.ryan.TurismClean.core.enums.TurismType;

import lombok.*;

import java.time.LocalDateTime;

public record TravelDto ( Long id,
                            String name,
                            String description,
                            String identifier,
                            LocalDateTime turismStart,
                            LocalDateTime turismEnd,
                            String localization,
                            Integer capacity,
                            String enterprise,
                            TurismType type) {

}
