package com.dev.ryan.TurismClean.infra.gateway;

import com.dev.ryan.TurismClean.core.domain.Travel;
import com.dev.ryan.TurismClean.core.gateway.TravelGateway;
import com.dev.ryan.TurismClean.infra.exceptions.BusinessException;
import com.dev.ryan.TurismClean.infra.exceptions.NotFoundTravelException;
import com.dev.ryan.TurismClean.infra.mapper.TravelEntityMapper;
import com.dev.ryan.TurismClean.infra.persistence.TravelEntity;
import com.dev.ryan.TurismClean.infra.persistence.TravelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Random;


@Component
@RequiredArgsConstructor
public class TravelRepositoryGateway implements TravelGateway {
    private final TravelRepository travelRepository;
    private final TravelEntityMapper travelEntityMapper;

    @Override
    public Travel createTravel(Travel travel) {
       Optional<TravelEntity> usuario = travelRepository.findByIdentifier(travel.identifier());
        if (usuario.isPresent()) {
            throw new BusinessException("Uma viagem com este indentificador já foi criada!");
        } else {
            TravelEntity travelAtualizado = travelEntityMapper.toEntity(travel);
            TravelEntity travelSaved = travelRepository.save(travelAtualizado);
            return travelEntityMapper.toDomain(travelSaved);
        }
    }

    @Override
    public List<Travel> findAllTravel() {

        return travelRepository.findAll().stream()
                .map(travelEntityMapper::toDomain)
                .toList();
    }

    @Override
    public Travel findIdentifier(String identifier) {
        Optional<TravelEntity> travel = travelRepository.findByIdentifier(identifier);
        return travel.map(travelEntityMapper::toDomain).orElseThrow(() ->
                new NotFoundTravelException("O identificador "+identifier+" não foi encontrado! Tente novamente!"));
    }

    @Override
    public String generateIdentifier() {
        Random random = new Random();

        StringBuilder letras = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            letras.append((char) ('A' + random.nextInt(26)));
        }
        int numero = 100 + random.nextInt(999);

        return letras + "-" +numero;

    }


}
