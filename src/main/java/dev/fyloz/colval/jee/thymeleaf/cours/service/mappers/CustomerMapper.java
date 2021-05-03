package dev.fyloz.colval.jee.thymeleaf.cours.service.mappers;

import dev.fyloz.colval.jee.thymeleaf.cours.model.dto.CustomerDto;
import dev.fyloz.colval.jee.thymeleaf.cours.model.entities.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper implements EntityMapper<Customer, CustomerDto> {
    @Override
    public CustomerDto entityToDto(Customer customer) {
        return new CustomerDto(
                customer.getCustomerId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getActive(),
                customer.getCreateDate().toLocalDateTime().toLocalDate(),
                customer.getLastUpdate().toLocalDateTime().toLocalDate(),
                customer.getAddress().getAddressId(),
                customer.getStore().getStoreId()
        );
    }
}
