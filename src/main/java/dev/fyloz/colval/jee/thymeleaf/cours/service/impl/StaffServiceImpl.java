package dev.fyloz.colval.jee.thymeleaf.cours.service.impl;

import dev.fyloz.colval.jee.thymeleaf.cours.model.entities.City;
import dev.fyloz.colval.jee.thymeleaf.cours.model.entities.Staff;
import dev.fyloz.colval.jee.thymeleaf.cours.repository.StaffRepository;
import dev.fyloz.colval.jee.thymeleaf.cours.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;

    @Autowired
    public StaffServiceImpl(StaffRepository staffRepository) {
        this.staffRepository = staffRepository;
    }

    @Override
    public Staff create(Staff staff) {
        return staffRepository.save(staff);
    }

    @Override
    public Optional<Staff> readOne(Long staffId) {
        return staffRepository.findById(staffId);
    }

    @Override
    public List<Staff> readAll() {
        return staffRepository.findAll();
    }

    @Override
    public void delete(Long staffId) {
        staffRepository.deleteById(staffId);
    }

    @Override
    public List<Staff> getAllTenRandomStaff() {
        List<Staff> staff = staffRepository.findAll();
        Collections.shuffle(staff);
        return staff.stream().limit(10).collect(Collectors.toList());
    }
}
