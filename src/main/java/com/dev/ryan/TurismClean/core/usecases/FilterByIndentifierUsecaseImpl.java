package com.dev.ryan.TurismClean.core.usecases;

import com.dev.ryan.TurismClean.core.domain.Travel;
import com.dev.ryan.TurismClean.core.gateway.TravelGateway;

import java.util.Optional;


public class FilterByIndentifierUsecaseImpl implements FilterByIndentifierUsecase {

    private final TravelGateway travelGateway;

    public FilterByIndentifierUsecaseImpl(TravelGateway travelGateway) {
        this.travelGateway = travelGateway;
    }

    @Override
    public Travel execute(String identifier) {
        return travelGateway.findIdentifier(identifier);
    }
}
