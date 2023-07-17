package com.example.springbootonlineshop.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;

@Entity
@Table(name = "tbl_accoutn")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(unique = true, nullable = false)
    String username;

    @Column(unique = true, nullable = false)
    String email;

    @Column(nullable = false)
    String password;
}
