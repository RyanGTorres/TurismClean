package com.dev.ryan.TurismClean.infra.persistence;

import com.dev.ryan.TurismClean.core.domain.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TravelRepository extends JpaRepository<TravelEntity, Long> {
    Optional<TravelEntity> findByIdentifier(String identifier);
}
