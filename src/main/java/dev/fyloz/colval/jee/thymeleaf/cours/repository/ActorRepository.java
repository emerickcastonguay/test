package dev.fyloz.colval.jee.thymeleaf.cours.repository;

import dev.fyloz.colval.jee.thymeleaf.cours.model.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Long> {
    Collection<Actor> findAllByOrderByActorIdAsc();

    List<Actor> findByFirstName(String firstName);

    List<Actor> findByLastName(String lastName);

    List<Actor> findByLastUpdate(Timestamp lastUpdate);
}
