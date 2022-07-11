package com.github.schedule.account;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
class AccountWarmup implements ApplicationListener<ContextRefreshedEvent> {

    private final AccountRepository accountRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        accountRepository.saveAll(
            List.of(
                Account.builder().id(UUID.randomUUID()).name("first Account").build(),
                Account.builder().id(UUID.randomUUID()).name("second Account").build()
            )
        );
    }
}
