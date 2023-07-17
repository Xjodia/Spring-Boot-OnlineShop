package com.example.springbootonlineshop.controller;

import com.example.springbootonlineshop.dto.AccountDTOCreate;
import com.example.springbootonlineshop.dto.AccountDTOResponse;
import com.example.springbootonlineshop.entity.Account;
import com.example.springbootonlineshop.mapper.AccountMapper;
import com.example.springbootonlineshop.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/accounts")
    public AccountDTOResponse createAccount(@RequestBody AccountDTOCreate accountDTOCreate){
        return accountService.createAccount(accountDTOCreate);
    }
}
