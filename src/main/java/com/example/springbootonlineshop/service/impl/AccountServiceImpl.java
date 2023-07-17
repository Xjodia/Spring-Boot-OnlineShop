package com.example.springbootonlineshop.service.impl;

import com.example.springbootonlineshop.dto.AccountDTOCreate;
import com.example.springbootonlineshop.dto.AccountDTOResponse;
import com.example.springbootonlineshop.entity.Account;
import com.example.springbootonlineshop.mapper.AccountMapper;
import com.example.springbootonlineshop.repository.AccountRepository;
import com.example.springbootonlineshop.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    @Override
    public AccountDTOResponse createAccount(AccountDTOCreate accountDTOCreate) {
        Account account = AccountMapper.toAccount(accountDTOCreate);
        account = accountRepository.save(account);
        return AccountMapper.toAccountResponse(account);
    }
}
