package com.dev.ryan.TurismClean.core.usecases;

import com.dev.ryan.TurismClean.core.domain.Travel;
import com.dev.ryan.TurismClean.core.gateway.TravelGateway;

public class GenerateIdentifierUsecaseImpl implements GenerateIdentifierUsecase{
    private final TravelGateway travelGateway;

    public GenerateIdentifierUsecaseImpl(TravelGateway travelGateway) {
        this.travelGateway = travelGateway;
    }

    @Override
    public String execute() {
        return travelGateway.generateIdentifier();
    }
}
