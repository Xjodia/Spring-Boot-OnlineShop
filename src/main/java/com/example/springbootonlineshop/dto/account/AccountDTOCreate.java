package com.example.springbootonlineshop.dto.account;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountDTOCreate {
    int id;
    String username;
    String email;
    String password;
}
