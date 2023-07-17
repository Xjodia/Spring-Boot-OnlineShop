package com.example.springbootonlineshop.mapper;

import com.example.springbootonlineshop.dto.AccountDTOCreate;
import com.example.springbootonlineshop.dto.AccountDTOResponse;
import com.example.springbootonlineshop.entity.Account;

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

}
