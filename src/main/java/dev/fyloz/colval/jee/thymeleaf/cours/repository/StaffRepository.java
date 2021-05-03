package dev.fyloz.colval.jee.thymeleaf.cours.repository;

import dev.fyloz.colval.jee.thymeleaf.cours.model.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.Optional;

public interface StaffRepository extends JpaRepository<Staff, Long> {
    Optional<Staff> findByFirstName(String firstName);

    Optional<Staff> findByLastName(String lastName);

    Optional<Staff> findByEmail(String email);

    Optional<Staff> findByActive(Byte active);

    Optional<Staff> findByUsername(String username);

    Optional<Staff> findByLastUpdate(Timestamp lastUpdate);
}
