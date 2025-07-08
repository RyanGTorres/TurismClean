package com.dev.ryan.TurismClean.core.gateway;

import com.dev.ryan.TurismClean.core.domain.Travel;


import java.util.List;

public interface TravelGateway {

    public Travel createTravel(Travel travel);

    public List<Travel> findAllTravel();

    public Travel findIdentifier(String identifier);

    public String generateIdentifier();
}
