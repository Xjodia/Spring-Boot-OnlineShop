package com.example.springbootonlineshop.controller;

import com.example.springbootonlineshop.dto.account.AccountDTOCreate;
import com.example.springbootonlineshop.dto.account.AccountDTOResponse;
import com.example.springbootonlineshop.service.AccountService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.springbootonlineshop.utils.Constant.API_VERSION;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequestMapping(API_VERSION)
public class AccountController {

    AccountService accountService;

    @PostMapping("/accounts")
    public AccountDTOResponse createAccount(@RequestBody AccountDTOCreate accountDTOCreate){
        return accountService.createAccount(accountDTOCreate);
    }
}
