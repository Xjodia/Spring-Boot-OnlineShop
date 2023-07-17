package com.example.springbootonlineshop.service;


import com.example.springbootonlineshop.dto.account.AccountDTOCreate;
import com.example.springbootonlineshop.dto.account.AccountDTOResponse;
import com.example.springbootonlineshop.dto.login.LoginDTORequest;
import com.example.springbootonlineshop.dto.login.LoginDTOResponse;

public interface AccountService {
    AccountDTOResponse createAccount(AccountDTOCreate accountDTOCreate);
    LoginDTOResponse login(LoginDTORequest loginDTORequest);
}
