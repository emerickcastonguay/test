package dev.fyloz.colval.jee.thymeleaf.cours.service;

import dev.fyloz.colval.jee.thymeleaf.cours.model.entities.Actor;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface ActorService {
    Actor create(Actor actor);

    Optional<Actor> readOne(Long actorId);

    List<Actor> readAll();

    void delete(Long actorId);

    List<Actor> getActorByFirstName(String firstName);

    List<Actor> getActorByLastName(String lastName);

    List<Actor> getActorByLastUpdate(Timestamp lastUpdate);

    Long countAllActor();

    List<Actor> findAllActorIdAscAndLimitTen();
}
