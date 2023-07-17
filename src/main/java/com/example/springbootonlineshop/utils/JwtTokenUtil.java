package com.example.springbootonlineshop.utils;

import com.example.springbootonlineshop.model.TokenPayload;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtTokenUtil {

    @Value("${JWT_SECRET_KEY}")
    private String SECRET_SIGNATURE;
    public String generateToken(TokenPayload tokenPayload, long expiredDate){
        Map<String, Object> claims = new HashMap<>();
        claims.put("payload", tokenPayload);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiredDate*1000))
                .signWith(SignatureAlgorithm.HS256, SECRET_SIGNATURE).compact();
    }

    public TokenPayload getTokenPayload(String token) {
        return getClaimsFromToken(token, (Claims claim) -> {
            @SuppressWarnings("unchecked")
            Map<String, Object> mapResult = (Map<String, Object>) claim.get("payload");
            return TokenPayload.builder()
                    .accountId((Integer) mapResult.get("accountId"))
                    .username((String) mapResult.get("username"))
                    .build();
        });
    }
    public <T> T getClaimsFromToken(String token, Function<Claims, T> claimResolver){
        final Claims claims = Jwts.parser()
                .setSigningKey(SECRET_SIGNATURE)
                .parseClaimsJwt(token).getBody();
        return claimResolver.apply(claims);
    }

    public boolean isTokenValid(String token, TokenPayload tokenPayloadFromAccount){
        if(isTokenExpired(token)) return false;
        TokenPayload tokenPayload = getTokenPayload(token);
        return tokenPayload.getAccountId() == tokenPayloadFromAccount.getAccountId()
                && tokenPayload.getUsername().equals(tokenPayloadFromAccount.getUsername()) ;
    }

    private boolean isTokenExpired(String token){
        Date expiredTime = getClaimsFromToken(token, Claims::getExpiration);
        return expiredTime.before(new Date());
    }
}
