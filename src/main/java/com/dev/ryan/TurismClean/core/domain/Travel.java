package com.dev.ryan.TurismClean.core.domain;

import com.dev.ryan.TurismClean.core.enums.TurismType;

import java.time.LocalDateTime;

public record Travel(
        Long id,
        String name,
        String description,
        String identifier,
        LocalDateTime turismStart,
        LocalDateTime turismEnd,
        String localization,
        Integer capacity,
        String enterprise,
        TurismType type
) {


}
