package dev.fyloz.colval.jee.thymeleaf.cours.repository;

import dev.fyloz.colval.jee.thymeleaf.cours.model.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
