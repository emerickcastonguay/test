package dev.fyloz.colval.jee.thymeleaf.cours.model.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SearchCustomerViewModel {
    private String query;
}
