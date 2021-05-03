package dev.fyloz.colval.jee.thymeleaf.cours.service;

import dev.fyloz.colval.jee.thymeleaf.cours.model.entities.Store;

import java.util.List;
import java.util.Optional;

public interface StoreService {
    Optional<Store> readOne(Long storeId);

    List<Store> readAll();

    void delete(Long storeId);

    Long countAllStore();
}
