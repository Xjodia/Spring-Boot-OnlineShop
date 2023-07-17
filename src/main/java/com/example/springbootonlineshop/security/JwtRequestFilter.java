package com.example.springbootonlineshop.security;

import com.example.springbootonlineshop.entity.Account;
import com.example.springbootonlineshop.mapper.AccountMapper;
import com.example.springbootonlineshop.model.TokenPayload;
import com.example.springbootonlineshop.repository.AccountRepository;
import com.example.springbootonlineshop.utils.JwtTokenUtil;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.expression.ExpressionException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JwtRequestFilter extends OncePerRequestFilter {
    JwtTokenUtil jwtTokenUtil;
    AccountRepository accountRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) {
        String requestTokenHeader = request.getHeader("Authorization");

        String token = null;
        TokenPayload tokenPayload = null;
        if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer")){
            token = requestTokenHeader.split(" ")[1];
            try {
                tokenPayload = jwtTokenUtil.getTokenPayload(token);
            }catch (ExpressionException exception){
                System.out.println("Token is expired");
            }
        }else {
            System.out.println("Jwt is not start with Bearer");
        }
        if(tokenPayload != null && SecurityContextHolder.getContext().getAuthentication() == null){
            Optional<Account> accountOptional = accountRepository.findById(tokenPayload.getAccountId());
            if(accountOptional.isPresent()){
                Account account = accountOptional.get();
                if(jwtTokenUtil.isTokenValid(token, AccountMapper.toTokenPayload(account))){
                    Authentication authentication = new UsernamePasswordAuthenticationToken(account, account.getPassword());
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                    //create account detail -> save into context Holder
                }
            }
        }
    }
}
