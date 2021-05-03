package dev.fyloz.colval.jee.thymeleaf.cours.service.impl;

import dev.fyloz.colval.jee.thymeleaf.cours.model.entities.Country;
import dev.fyloz.colval.jee.thymeleaf.cours.repository.CountryRepository;
import dev.fyloz.colval.jee.thymeleaf.cours.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country create(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Optional<Country> readOne(Long countryId) {
        return countryRepository.findById(countryId);
    }

    @Override
    public List<Country> readAll() {
        return countryRepository.findAll();
    }

    @Override
    public void delete(Long countryId) {
        countryRepository.deleteById(countryId);
    }

    @Override
    public Long countAllCountry() {
        return countryRepository.count();
    }
}
