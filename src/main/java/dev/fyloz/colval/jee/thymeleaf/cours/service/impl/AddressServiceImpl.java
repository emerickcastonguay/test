package dev.fyloz.colval.jee.thymeleaf.cours.service.impl;

import dev.fyloz.colval.jee.thymeleaf.cours.model.entities.Address;
import dev.fyloz.colval.jee.thymeleaf.cours.repository.AddressRepository;
import dev.fyloz.colval.jee.thymeleaf.cours.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address create(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public Optional<Address> readOne(Long addressId) {
        return addressRepository.findById(addressId);
    }

    @Override
    public List<Address> readAll() {
        return addressRepository.findAll();
    }

    @Override
    public void delete(Long addressId) {
        addressRepository.deleteById(addressId);
    }
}
