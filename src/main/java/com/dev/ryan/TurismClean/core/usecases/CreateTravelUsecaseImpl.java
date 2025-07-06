package com.dev.ryan.TurismClean.core.usecases;

import com.dev.ryan.TurismClean.core.domain.Travel;
import com.dev.ryan.TurismClean.core.gateway.TravelGateway;

public class CreateTravelUsecaseImpl implements CreateTravelUsecase {

    private final TravelGateway travelGateway;

    public CreateTravelUsecaseImpl(TravelGateway travelGateway) {
        this.travelGateway = travelGateway;
    }

    @Override
    public Travel execute(Travel travel) {
        return travelGateway.createTravel(travel);
    }
}
