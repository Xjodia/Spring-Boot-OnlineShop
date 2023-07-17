package com.example.springbootonlineshop.dto.login;

import com.example.springbootonlineshop.dto.account.AccountDTOResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginDTOResponse {
    String accessToken;
    AccountDTOResponse account;
}
