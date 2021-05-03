package dev.fyloz.colval.jee.thymeleaf.cours.repository;

import dev.fyloz.colval.jee.thymeleaf.cours.model.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findAllByOrderByCustomerId();

    List<Customer> findAllByOrderByLastNameAsc();

    @Query("SELECT c FROM Customer c WHERE c.firstName LIKE %:query% OR c.lastName LIKE %:query% ORDER BY c.customerId")
    List<Customer> findByFirstNameOrLastNameContaining(String query);
}
