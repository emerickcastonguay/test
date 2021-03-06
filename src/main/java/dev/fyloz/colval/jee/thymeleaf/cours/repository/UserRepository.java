package dev.fyloz.colval.jee.thymeleaf.cours.repository;

import dev.fyloz.colval.jee.thymeleaf.cours.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findOneByUsername(String username);
}
