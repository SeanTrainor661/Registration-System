package com.aeroparker.registration.repository;

import com.aeroparker.registration.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmailAddressIgnoreCase(String emailAddress);
}
