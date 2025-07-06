package com.dev.ryan.TurismClean.infra.presentation;

import com.dev.ryan.TurismClean.core.domain.Travel;
import com.dev.ryan.TurismClean.core.usecases.CreateTravelUsecase;
import com.dev.ryan.TurismClean.core.usecases.FilterByIndentifierUsecase;
import com.dev.ryan.TurismClean.core.usecases.FindTravelUsecase;
import com.dev.ryan.TurismClean.infra.dtos.TravelDto;
import com.dev.ryan.TurismClean.infra.mapper.TravelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class TravelController {
    private final CreateTravelUsecase createTravelUsecase;
    private final FindTravelUsecase findTravelUsecase;
    private final FilterByIndentifierUsecase filterByIndentifierUsecase;
    private final TravelMapper travelMapper;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createTravel(@RequestBody TravelDto travel){
        Travel newTravel = createTravelUsecase.execute(travelMapper.toDomain(travel));
        Map<String, Object> response = new HashMap<>();
        response.put("Mensagem", "A viagem foi criada com sucesso!");
        response.put("Dados da viagem", travelMapper.toDTO(newTravel));

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<TravelDto>>  findTravel(){
        return ResponseEntity.ok(findTravelUsecase.execute().stream()
                .map(travelMapper::toDTO)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<Optional<Travel>>  findTravelByIdentifier(@PathVariable String identifier){
        Optional<Travel> travel = filterByIndentifierUsecase.execute(identifier);
        return ResponseEntity.ok(travel);
    }

}
