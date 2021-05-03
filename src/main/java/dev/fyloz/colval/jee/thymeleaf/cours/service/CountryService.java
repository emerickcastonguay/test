package dev.fyloz.colval.jee.thymeleaf.cours.service;

import dev.fyloz.colval.jee.thymeleaf.cours.model.entities.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    Country create(Country country);

    Optional<Country> readOne(Long countryId);

    List<Country> readAll();

    void delete(Long countryId);

    Long countAllCountry();
}
