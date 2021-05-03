package dev.fyloz.colval.jee.thymeleaf.cours.repository;

import dev.fyloz.colval.jee.thymeleaf.cours.model.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
