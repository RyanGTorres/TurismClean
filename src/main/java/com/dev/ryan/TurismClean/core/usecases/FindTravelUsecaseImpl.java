package com.dev.ryan.TurismClean.core.usecases;

import com.dev.ryan.TurismClean.core.domain.Travel;
import com.dev.ryan.TurismClean.core.gateway.TravelGateway;

import java.util.List;

public class FindTravelUsecaseImpl implements FindTravelUsecase {

    private final TravelGateway travelGateway;

    public FindTravelUsecaseImpl(TravelGateway travelGateway) {
        this.travelGateway = travelGateway;
    }

    @Override
    public List<Travel> execute() {
        return travelGateway.findAllTravel();
    }
}
