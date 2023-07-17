package com.example.springbootonlineshop.repository;

import com.example.springbootonlineshop.dto.login.LoginDTORequest;
import com.example.springbootonlineshop.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findByUsername(String username);
}
