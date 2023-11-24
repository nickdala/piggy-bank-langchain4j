package com.nickthecloudguy.services;

import org.springframework.stereotype.Component;

import com.nickthecloudguy.services.CustomerService.CustomerRecord;

import dev.langchain4j.agent.tool.Tool;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AccountTools {
    private final AccountService accountService;
    private final CustomerService customerService;

    @Tool("Close account by id")
    public boolean closeAccount(long accountId) {
        accountService.closeAccount(accountId);
        return true;
    }

    @Tool("Finds the customer by id")
    public CustomerRecord findCustomerById(long customerId) {
        return customerService.findCustomertById(customerId);
    }

    @Tool("Finds the customer by email")
    public CustomerRecord findCustomerByEmail(String email) {
        return customerService.findCustomertByEmail(email);
    }



}
