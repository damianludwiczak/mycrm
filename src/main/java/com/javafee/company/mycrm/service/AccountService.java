package com.javafee.company.mycrm.service;

import com.javafee.company.mycrm.controller.dto.AccountDto;
import com.javafee.company.mycrm.repository.domain.Account;
import com.javafee.company.mycrm.repository.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public List<AccountDto> findAll() {
        List<AccountDto> accountDtoList = new ArrayList<>();
        List<Account> accountList = accountRepository.findAll();
        for (Account account : accountList)
            accountDtoList.add(fromAccountTocAccountDto(account));
        return accountDtoList;
    }

    public void save(AccountDto accountDto) {
        accountRepository.save(fromAccountDtoToAccount(accountDto));
    }

    private AccountDto fromAccountTocAccountDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setId(account.getId());
        accountDto.setLogin(account.getLogin());
        accountDto.setPassword(account.getPassword());
        accountDto.setCreated(account.getCreated());
        accountDto.setLastLogin(account.getLastLogin());
        return accountDto;
    }

    private Account fromAccountDtoToAccount(AccountDto accountDto) {
        Account account = new Account();
        account.setId(accountDto.getId());
        account.setLogin(accountDto.getLogin());
        account.setPassword(accountDto.getPassword());
        account.setCreated(accountDto.getCreated());
        account.setLastLogin(accountDto.getLastLogin());
        return account;
    }
}
