package dev.fyloz.colval.jee.thymeleaf.cours.service.mappers;

public interface EntityMapper<T, D> {
    D entityToDto(T t);
}
