package dev.fyloz.colval.jee.thymeleaf.cours.service.impl;

import dev.fyloz.colval.jee.thymeleaf.cours.model.dto.CustomerDto;
import dev.fyloz.colval.jee.thymeleaf.cours.model.entities.Address;
import dev.fyloz.colval.jee.thymeleaf.cours.model.entities.Customer;
import dev.fyloz.colval.jee.thymeleaf.cours.model.entities.Store;
import dev.fyloz.colval.jee.thymeleaf.cours.model.view.SearchCustomerViewModel;
import dev.fyloz.colval.jee.thymeleaf.cours.repository.CustomerRepository;
import dev.fyloz.colval.jee.thymeleaf.cours.service.AddressService;
import dev.fyloz.colval.jee.thymeleaf.cours.service.CustomerService;
import dev.fyloz.colval.jee.thymeleaf.cours.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final AddressService addressService;
    private final StoreService storeService;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, AddressService addressService, StoreService storeService) {
        this.customerRepository = customerRepository;
        this.addressService = addressService;
        this.storeService = storeService;
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> readOne(Long id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> readAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> search(SearchCustomerViewModel searchViewModel) {
        return search(searchViewModel.getQuery());
    }

    @Override
    public List<Customer> search(String searchQuery) {
        return customerRepository.findByFirstNameOrLastNameContaining(searchQuery).stream().limit(100).collect(Collectors.toList());
    }

    @Override
    public Customer save(CustomerDto customer) {
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);

        Address address = addressService.readOne(customer.getAddressId()).get();
        Store store = storeService.readAll().stream().findFirst().get();

        Customer newCustomer = new Customer();
        newCustomer.setFirstName(customer.getFirstName());
        newCustomer.setLastName(customer.getLastName());
        newCustomer.setEmail(customer.getEmail());
        newCustomer.setActive(customer.isActive());
        newCustomer.setCreateDate(timestamp);
        newCustomer.setLastUpdate(timestamp);
        newCustomer.setAddress(address);
        newCustomer.setStore(store);

        return customerRepository.save(newCustomer);
    }

    @Override
    public void update(CustomerDto customer) {
        Optional<Customer> storedOptional = readOne(customer.getCustomerId());

        if (storedOptional.isPresent()) {
            Customer stored = storedOptional.get();

            LocalDateTime now = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(now);

            Address address = addressService.readOne(customer.getAddressId()).get();
            Store store = storeService.readAll().stream().findFirst().get();

            stored.setFirstName(customer.getFirstName());
            stored.setLastName(customer.getLastName());
            stored.setEmail(customer.getEmail());
            stored.setActive(customer.isActive());
            stored.setLastUpdate(timestamp);
            stored.setAddress(address);
            stored.setStore(store);

            customerRepository.save(stored);
        }
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public List<Customer> getAllCustomerSortedByLastName() {
        return customerRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Customer updateFirstNameAndLastName(Long customerId, String firstName, String lastName) {
        Optional<Customer> customerRecover = this.readOne(customerId);
        if (customerRecover.isEmpty()) throw new RuntimeException("Customer Id not found");
        Customer customer = customerRecover.get();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        return customerRepository.save(customer);
    }

    @Override
    public Long countAllCustomer() {
        return customerRepository.count();
    }

    @Override
    public List<Customer> findAllCustomerIdDescAndLimitTen() {
        return customerRepository.findAllByOrderByCustomerId().stream().limit(100).collect(Collectors.toList());
    }
}
