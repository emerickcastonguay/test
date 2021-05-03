package dev.fyloz.colval.jee.thymeleaf.cours.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private boolean active;
    private LocalDate createDate;
    private LocalDate lastUpdate;
    private Long addressId;
    private Long storeId;
}
