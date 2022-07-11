package com.github.schedule.account;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
class AccountController {

    private final AccountRepository accountRepository;

    @GetMapping("/api/accounts")
    List<Account> accounts() {
        return accountRepository.findAll();
    }

    @GetMapping("/api/accounts/{id}")
    ResponseEntity<Account> findAccountById(@PathVariable String id) {
        var account = accountRepository.findById(UUID.fromString(id));
        return account.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.noContent().build());
    }
}
