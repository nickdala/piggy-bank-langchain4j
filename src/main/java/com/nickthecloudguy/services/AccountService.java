package com.nickthecloudguy.services;

import java.text.NumberFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nickthecloudguy.data.Account;
import com.nickthecloudguy.data.AccountRepository;
import com.nickthecloudguy.data.AccountStatus;
import com.vaadin.flow.server.auth.AnonymousAllowed;

import dev.hilla.BrowserCallable;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@BrowserCallable
@AnonymousAllowed
@Service
@AllArgsConstructor
@Slf4j
public class AccountService {

    private final AccountRepository accountRepository;

    public record AccountRecord(
        long id,
        String accountType,
        String accountStatus,
        String balance
    ) {
    }

    private AccountRecord toRecord(Account account) {
        return new AccountRecord(
            account.getId(),
            account.getAccountType().name(),
            account.getAccountStatus().name(),
            NumberFormat.getCurrencyInstance().format(account.getBalance() / 100.0)
        );
    }

    public List<AccountRecord> findAllAccountsForCustomer(long customerId) {
        return accountRepository.findByCustomerId(customerId).stream()
            .map(this::toRecord)
            .collect(Collectors.toList());
    }

    public AccountRecord findAccountById(long accountId) {
        return accountRepository.findById(accountId)
            .map(this::toRecord)
            .orElseThrow();
    }

    public AccountRecord closeAccount(long accountId) {
        log.info("Closing account {}", accountId);
        Account account = accountRepository.findById(accountId).orElseThrow();
        account.setAccountStatus(AccountStatus.CLOSED);
        return toRecord(accountRepository.save(account));
    }

}
