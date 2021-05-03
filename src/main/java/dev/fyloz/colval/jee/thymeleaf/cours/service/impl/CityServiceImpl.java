package dev.fyloz.colval.jee.thymeleaf.cours.service.impl;

import dev.fyloz.colval.jee.thymeleaf.cours.model.entities.City;
import dev.fyloz.colval.jee.thymeleaf.cours.repository.CityRepository;
import dev.fyloz.colval.jee.thymeleaf.cours.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City create(City city) {
        return cityRepository.save(city);
    }

    @Override
    public Optional<City> readOne(Long cityId) {
        return cityRepository.findById(cityId);
    }

    @Override
    public List<City> readAll() {
        return cityRepository.findAll();
    }

    @Override
    public void delete(Long cityId) {
        cityRepository.deleteById(cityId);
    }

    @Override
    public Long countAllCity() {
        return cityRepository.count();
    }

    @Override
    public List<City> getAllTenRandomCity() {
        List<City> cities = cityRepository.findAll();
        Collections.shuffle(cities);
        return cities.stream().limit(10).collect(Collectors.toList());
    }
}
