package dev.fyloz.colval.jee.thymeleaf.cours.web.rest;

import dev.fyloz.colval.jee.thymeleaf.cours.model.dto.CustomerDto;
import dev.fyloz.colval.jee.thymeleaf.cours.model.dto.UserDto;
import dev.fyloz.colval.jee.thymeleaf.cours.model.entities.Customer;
import dev.fyloz.colval.jee.thymeleaf.cours.service.CustomerService;
import dev.fyloz.colval.jee.thymeleaf.cours.service.mappers.EntityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customer")
public class CustomerResource {
    private final CustomerService customerService;
    private final EntityMapper<Customer, CustomerDto> mapper;
    private final Logger log = LoggerFactory.getLogger(CustomerResource.class);

    public CustomerResource(CustomerService customerService, EntityMapper<Customer, CustomerDto> mapper) {
        this.customerService = customerService;
        this.mapper = mapper;
    }

    @GetMapping
    public List<CustomerDto> getAll() {
        return this.customerService.readAll().stream()
                .map(mapper::entityToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Optional<Customer> customer = this.customerService.readOne(id);
        return customer.map(value -> ResponseEntity.ok(mapper.entityToDto(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/search/{searchQuery}")
    public ResponseEntity<Collection<CustomerDto>> getBySearch(@PathVariable String searchQuery) {
        return ResponseEntity.ok(
                this.customerService.search(searchQuery).stream()
                        .map(mapper::entityToDto)
                        .collect(Collectors.toList())
        );
    }

    @PostMapping("/add")
    public ResponseEntity<Void> save(@RequestBody @Valid CustomerDto customer) {
        Customer saved = this.customerService.save(customer);
        return ResponseEntity
                .created(URI.create(saved.getCustomerId().toString()))
                .build();
    }

    @PutMapping("/edit")
    public ResponseEntity<Void> update(@RequestBody @Valid CustomerDto customer) {
        this.customerService.update(customer);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.customerService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> findUser(@PathVariable Integer id) {
        try {
            String url = "https://reqres.in/api/users/" + id;
            RestTemplate restTemplate = new RestTemplate();
            UserDto user = restTemplate.getForObject(url, UserDto.class);

            return ResponseEntity.ok(user);
        } catch (HttpClientErrorException e) {
            log.error("Error {}", e.getLocalizedMessage(), e);
            return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
