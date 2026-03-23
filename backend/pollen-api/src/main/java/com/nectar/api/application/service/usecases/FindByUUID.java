package com.nectar.api.application.service.usecases;

import java.util.Optional;
import java.util.UUID;

public interface FindByUUID<O>{
    Optional<O> findByIdPublic(UUID key);
}
