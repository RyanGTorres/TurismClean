package com.dev.ryan.TurismClean.core.usecases;

import com.dev.ryan.TurismClean.core.domain.Travel;

import java.util.Optional;

public interface FilterByIndentifierUsecase {
    public Travel execute(String identifier);
}
