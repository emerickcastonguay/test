package dev.fyloz.colval.jee.thymeleaf.cours.service.impl;

import dev.fyloz.colval.jee.thymeleaf.cours.model.entities.Actor;
import dev.fyloz.colval.jee.thymeleaf.cours.repository.ActorRepository;
import dev.fyloz.colval.jee.thymeleaf.cours.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements ActorService {
    private final ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public Actor create(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Optional<Actor> readOne(Long actorId) {
        return actorRepository.findById(actorId);
    }

    @Override
    public List<Actor> readAll() {
        return actorRepository.findAll();
    }

    @Override
    public void delete(Long actorId) {
        actorRepository.deleteById(actorId);
    }

    @Override
    public List<Actor> getActorByFirstName(String firstName) {
        return actorRepository.findByFirstName(firstName);
    }

    @Override
    public List<Actor> getActorByLastName(String lastName) {
        return actorRepository.findByLastName(lastName);
    }

    @Override
    public List<Actor> getActorByLastUpdate(Timestamp lastUpdate) {
        return actorRepository.findByLastUpdate(lastUpdate);
    }

    @Override
    public Long countAllActor() {
        return actorRepository.count();
    }

    @Override
    public List<Actor> findAllActorIdAscAndLimitTen() {
        return actorRepository.findAllByOrderByActorIdAsc().stream().limit(10).collect(Collectors.toList());
    }
}
