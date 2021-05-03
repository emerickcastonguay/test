package dev.fyloz.colval.jee.thymeleaf.cours.controllers;

import dev.fyloz.colval.jee.thymeleaf.cours.model.dto.CustomerDto;
import dev.fyloz.colval.jee.thymeleaf.cours.model.entities.Customer;
import dev.fyloz.colval.jee.thymeleaf.cours.model.view.SearchCustomerViewModel;
import dev.fyloz.colval.jee.thymeleaf.cours.service.AddressService;
import dev.fyloz.colval.jee.thymeleaf.cours.service.CustomerService;
import dev.fyloz.colval.jee.thymeleaf.cours.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("customers")
public class CustomerController {
    private final CustomerService customerService;
    private final AddressService addressService;
    private final StoreService storeService;

    private SearchCustomerViewModel searchQuery;

    @Autowired
    public CustomerController(CustomerService customerService, AddressService addressService, StoreService storeService) {
        this.customerService = customerService;
        this.addressService = addressService;
        this.storeService = storeService;
    }

    @GetMapping("")
    public String customers(Model model) {
        if (searchQuery == null || searchQuery.getQuery().isEmpty()) {
            return customers(model, customerService.findAllCustomerIdDescAndLimitTen(), new SearchCustomerViewModel());
        } else {
            return customers(model, customerService.search(searchQuery), searchQuery);
        }
    }

    @GetMapping("search")
    public String searchCustomer(Model model, SearchCustomerViewModel searchViewModel) {
        searchQuery = searchViewModel;
        return "redirect:/customers/";
    }

    @GetMapping("{id}")
    public String customer(Model model, @PathVariable Long id) {
        model.addAttribute("customer", customerService.readOne(id).get());
        return "customer/details";
    }

    @GetMapping("add")
    public String addCustomer(Model model) {
        model.addAttribute("customer", new CustomerDto());
        model.addAttribute("addresses", addressService.readAll());
        model.addAttribute("stores", storeService.readAll());
        return "customer/add";
    }

    @PostMapping("save")
    public String saveCustomer(@Valid CustomerDto customer) {
        Customer saved = customerService.save(customer);
        return "redirect:/customers/" + saved.getCustomerId();
    }

    @GetMapping("delete/{id}")
    public String deleteCustomer(Model model, @PathVariable Long id) {
        customerService.delete(id);
        return "redirect:/customers/";
    }

    private String customers(Model model, List<Customer> customers, SearchCustomerViewModel searchViewModel) {
        model.addAttribute("searchViewModel", searchViewModel);
        model.addAttribute("customers", customers);
        model.addAttribute("customerCount", customers.size());
        return "customer/list";
    }
}
