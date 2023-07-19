package com.example.springbootonlineshop.service.impl;

import com.example.springbootonlineshop.dto.account.AccountDTOCreate;
import com.example.springbootonlineshop.dto.account.AccountDTOResponse;
import com.example.springbootonlineshop.dto.login.LoginDTORequest;
import com.example.springbootonlineshop.dto.login.LoginDTOResponse;
import com.example.springbootonlineshop.entity.Account;
import com.example.springbootonlineshop.mapper.AccountMapper;
import com.example.springbootonlineshop.repository.AccountRepository;
import com.example.springbootonlineshop.service.AccountService;
import com.example.springbootonlineshop.utils.JwtTokenUtil;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AccountServiceImpl implements AccountService {

    AccountRepository accountRepository;
    PasswordEncoder passwordEncoder;
    JwtTokenUtil jwtTokenUtil;

    @Override
    public AccountDTOResponse createAccount(AccountDTOCreate accountDTOCreate) {
        Account account = AccountMapper.toAccount(accountDTOCreate);
        //encode password
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account = accountRepository.save(account);
        return AccountMapper.toAccountResponse(account);
    }

    @Override
    public LoginDTOResponse login(LoginDTORequest loginDTORequest) {
        //get account by username
        Account account = accountRepository.findByUsername(loginDTORequest.getUsername())
                .orElseThrow(() -> new RuntimeException("Account not found"));
        //check password
        boolean isAuthentication = passwordEncoder.matches(
                loginDTORequest.getPassword(), account.getPassword());
        if(!isAuthentication) {
            throw new RuntimeException("Username or password is incorrect");
        }
        //ok -> generate token
        final int ONE_DAY_SECONDS = 24 * 60 * 60;
        String accessToken = jwtTokenUtil.generateToken(AccountMapper.toTokenPayload(account), ONE_DAY_SECONDS);
        //return user
        return LoginDTOResponse.builder()
                .account(AccountMapper.toAccountResponse(account))
                .accessToken(accessToken)
                .build();
    }
}
