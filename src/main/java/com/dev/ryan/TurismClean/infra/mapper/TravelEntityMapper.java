package com.dev.ryan.TurismClean.infra.mapper;

import com.dev.ryan.TurismClean.core.domain.Travel;
import com.dev.ryan.TurismClean.infra.gateway.TravelRepositoryGateway;
import com.dev.ryan.TurismClean.infra.persistence.TravelEntity;
import org.springframework.stereotype.Component;

@Component
public class TravelEntityMapper {



    public TravelEntity toEntity(Travel travel){
        return new TravelEntity(
                travel.id(),
                travel.name(),
                travel.description(),
                travel.identifier(),
                travel.turismStart(),
                travel.turismEnd(),
                travel.localization(),
                travel.capacity(),
                travel.enterprise(),
                travel.type()
        );
    }

    public Travel toDomain(TravelEntity travelEntity){
        return new Travel(
                travelEntity.getId(),
                travelEntity.getName(),
                travelEntity.getDescription(),
                travelEntity.getIdentifier(),
                travelEntity.getTurismStart(),
                travelEntity.getTurismEnd(),
                travelEntity.getLocalization(),
                travelEntity.getCapacity(),
                travelEntity.getEnterprise(),
                travelEntity.getType()
        );

    }
}
