package dev.fyloz.colval.jee.thymeleaf.cours.controllers;

import dev.fyloz.colval.jee.thymeleaf.cours.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    private final CustomerService customerService;

    @Autowired
    public IndexController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("customerCount", customerService.countAllCustomer());
        return "index/index";
    }

    @GetMapping("login")
    public String login() {
        return "index/login";
    }
}
