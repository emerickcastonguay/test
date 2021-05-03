package dev.fyloz.colval.jee.thymeleaf.cours.service;

import dev.fyloz.colval.jee.thymeleaf.cours.model.entities.City;

import java.util.List;
import java.util.Optional;

public interface CityService {
    City create(City city);

    Optional<City> readOne(Long cityId);

    List<City> readAll();

    void delete(Long cityId);

    Long countAllCity();

    List<City> getAllTenRandomCity();
}
