package com.dev.ryan.TurismClean.infra.configuration;

import com.dev.ryan.TurismClean.core.gateway.TravelGateway;
import com.dev.ryan.TurismClean.core.usecases.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TravelConfiguration {
    @Bean
    public CreateTravelUsecase createTravelUsecase(TravelGateway travelGateway){
        return new CreateTravelUsecaseImpl(travelGateway);
    }

    @Bean
    public FindTravelUsecase findTravelUsecase (TravelGateway travelGateway){
        return new FindTravelUsecaseImpl(travelGateway);
    }

    @Bean
    public FilterByIndentifierUsecase filterByIndentifierUsecase (TravelGateway travelGateway){
        return new FilterByIndentifierUsecaseImpl(travelGateway);
    }

    @Bean
    public GenerateIdentifierUsecase generateIdentifierUsecase(TravelGateway travelGateway){
        return new GenerateIdentifierUsecaseImpl(travelGateway);
    }
}
