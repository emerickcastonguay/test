package dev.fyloz.colval.jee.thymeleaf.cours.service.impl;

import dev.fyloz.colval.jee.thymeleaf.cours.model.entities.Store;
import dev.fyloz.colval.jee.thymeleaf.cours.repository.StoreRepository;
import dev.fyloz.colval.jee.thymeleaf.cours.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;

    @Autowired
    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public Optional<Store> readOne(Long storeId) {
        return storeRepository.findById(storeId);
    }

    @Override
    public List<Store> readAll() {
        return storeRepository.findAll();
    }

    @Override
    public void delete(Long storeId) {
        storeRepository.deleteById(storeId);
    }

    @Override
    public Long countAllStore() {
        return storeRepository.count();
    }

}
