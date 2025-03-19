package com.aeroparker.registration.controller;

import com.aeroparker.registration.model.Customer;
import com.aeroparker.registration.repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Optional;

@Controller
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "registration";  // Make sure this matches the Thymeleaf template name
    }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "success";  // This looks for success.html in src/main/resources/templates/
    }

    @PostMapping("/registration")
    public String submitForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registration";
        }

        // Ensure email is unique
        Optional<Customer> existingCustomer = customerRepository.findByEmailAddressIgnoreCase(customer.getEmailAddress());
        if (existingCustomer.isPresent()) {
            model.addAttribute("emailError", "Email already registered!");
            return "registration";
        }

        customerRepository.save(customer);
        return "redirect:/success";  // Redirect to success page
    }
}
