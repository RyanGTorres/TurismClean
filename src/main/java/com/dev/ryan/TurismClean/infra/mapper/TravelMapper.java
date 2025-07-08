package com.dev.ryan.TurismClean.infra.mapper;

import com.dev.ryan.TurismClean.core.domain.Travel;
import com.dev.ryan.TurismClean.infra.dtos.TravelDto;
import com.dev.ryan.TurismClean.infra.gateway.TravelRepositoryGateway;
import org.springframework.stereotype.Component;

@Component
public class TravelMapper {

    private final TravelRepositoryGateway repositoryGateway;

    public TravelMapper(TravelRepositoryGateway repositoryGateway) {
        this.repositoryGateway = repositoryGateway;
    }

    public TravelDto toDTO (Travel travel){
        return new TravelDto(
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

    public Travel toDomain (TravelDto dto){
        return new Travel(
                dto.id(),
                dto.name(),
                dto.description(),
                repositoryGateway.generateIdentifier(),
                dto.turismStart(),
                dto.turismEnd(),
                dto.localization(),
                dto.capacity(),
                dto.enterprise(),
                dto.type()
        );
    }

}
