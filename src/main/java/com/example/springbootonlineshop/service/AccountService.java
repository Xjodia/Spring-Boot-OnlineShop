package com.example.springbootonlineshop.service;


import com.example.springbootonlineshop.dto.AccountDTOCreate;
import com.example.springbootonlineshop.dto.AccountDTOResponse;

public interface AccountService {
    AccountDTOResponse createAccount(AccountDTOCreate accountDTOCreate);
}
