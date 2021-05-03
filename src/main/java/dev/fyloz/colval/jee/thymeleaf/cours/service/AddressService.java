package dev.fyloz.colval.jee.thymeleaf.cours.service;

import dev.fyloz.colval.jee.thymeleaf.cours.model.entities.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    Address create(Address address);

    Optional<Address> readOne(Long addressId);

    List<Address> readAll();

    void delete(Long addressId);
}
