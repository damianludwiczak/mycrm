package com.javafee.company.mycrm.controller;

import com.javafee.company.mycrm.controller.dto.AccountDto;
import com.javafee.company.mycrm.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController implements AccountApi {
    private final AccountService accountService;

    @Override
    public ResponseEntity<List<AccountDto>> findAllAccounts() {
        return ResponseEntity.ok(accountService.findAll());
    }

    @Override
    public ResponseEntity<AccountDto> createAccount(AccountDto accountDto) {
        accountService.save(accountDto);
        return ResponseEntity.ok().build();
    }
}
