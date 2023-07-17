package com.example.springbootonlineshop.mapper;

import com.example.springbootonlineshop.dto.account.AccountDTOCreate;
import com.example.springbootonlineshop.dto.account.AccountDTOResponse;
import com.example.springbootonlineshop.entity.Account;
import com.example.springbootonlineshop.model.TokenPayload;

public class AccountMapper {
    public static Account toAccount(AccountDTOCreate accountDTOCreate) {
        return Account.builder()
                .username(accountDTOCreate.getUsername())
                .password(accountDTOCreate.getPassword())
                .email(accountDTOCreate.getEmail())
                .build();
    }

    public static AccountDTOResponse toAccountResponse(Account account) {
        return AccountDTOResponse.builder()
                .id(account.getId())
                .username(account.getUsername())
                .email(account.getEmail())
                .build();
    }

    public static TokenPayload toTokenPayload(Account account) {
        return TokenPayload.builder()
                .accountId(account.getId())
                .username(account.getUsername())
                .build();
    }
}
