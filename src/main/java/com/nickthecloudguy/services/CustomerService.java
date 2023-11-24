package com.nickthecloudguy.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nickthecloudguy.data.Customer;
import com.nickthecloudguy.data.CustomerRepository;

import com.vaadin.flow.server.auth.AnonymousAllowed;

import dev.hilla.BrowserCallable;
import lombok.AllArgsConstructor;

@BrowserCallable
@AnonymousAllowed
@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public record CustomerRecord(
        long id,
        String firstName,
        String lastName,
        String email
    ) {
    }

    private CustomerRecord toRecord(Customer customer) {
        return new CustomerRecord(
            customer.getId(),
            customer.getFirstName(),
            customer.getLastName(),
            customer.getEmail()
        );
    }

    public List<CustomerRecord> findAllCustomers() {
        return customerRepository.findAll().stream()
            .map(this::toRecord)
            .collect(Collectors.toList());
    }

    public CustomerRecord findCustomertById(long customerId) {
        return customerRepository.findById(customerId)
            .map(this::toRecord)
            .orElseThrow();
    }

    public CustomerRecord findCustomertByEmail(String email) {
        return customerRepository.findByEmailIgnoreCase(email)
            .map(this::toRecord)
            .orElseThrow();
    }
}
