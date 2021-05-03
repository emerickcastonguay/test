package dev.fyloz.colval.jee.thymeleaf.cours.service;

import dev.fyloz.colval.jee.thymeleaf.cours.model.dto.CustomerDto;
import dev.fyloz.colval.jee.thymeleaf.cours.model.entities.Customer;
import dev.fyloz.colval.jee.thymeleaf.cours.model.view.SearchCustomerViewModel;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer create(Customer customer);

    Optional<Customer> readOne(Long id);

    List<Customer> readAll();

    List<Customer> search(SearchCustomerViewModel searchViewModel);

    List<Customer> search(String searchQuery);

    Customer save(CustomerDto customer);

    void update(CustomerDto customer);

    void delete(Long id);

    List<Customer> getAllCustomerSortedByLastName();

    Customer updateFirstNameAndLastName(Long customerId, String firstName, String lastName);

    Long countAllCustomer();

    List<Customer> findAllCustomerIdDescAndLimitTen();
}
