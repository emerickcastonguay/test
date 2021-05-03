package dev.fyloz.colval.jee.thymeleaf.cours.service;

import dev.fyloz.colval.jee.thymeleaf.cours.model.entities.Staff;

import java.util.List;
import java.util.Optional;

public interface StaffService {
    Staff create(Staff staff);

    Optional<Staff> readOne(Long staffId);

    List<Staff> readAll();

    void delete(Long staffId);

    List<Staff> getAllTenRandomStaff();
}
