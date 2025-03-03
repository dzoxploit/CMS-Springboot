package com.example.cmsspringboot.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    private static final String SECRET = "SuperSecretKeyForJWTMustBeAtLeast32Chars";
    private static final long EXPIRATION_TIME = 864000000;
    
    
    private final Key key = Keys.hmacShaKeyFor(SECRET.getBytes());

    public String generateTokenAuth(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsernameAuth(String token){
        return Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(token)
                .getBody().getSubject();
    }

    public boolean validateTokenAuth(String token){
        try{
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        }catch(JwtException e){
            return false;
        }
    }
}
