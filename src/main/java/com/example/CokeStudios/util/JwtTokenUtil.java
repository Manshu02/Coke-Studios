package com.example.CokeStudios.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtTokenUtil {

    private final String secret = "K4SxPQvqBxhZoCpU5D0TUbR3MvqYF7PcH67e3f4O8Oc=\n";
    private final long expiration = 86400L; // 24 hours

    public String generateToken(String username, String role) {
        return JWT.create()
                .withSubject(username)
                .withClaim("role", role)  // Add the role claim
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + expiration * 1000))
                .sign(Algorithm.HMAC512(secret.getBytes()));
    }


    public String getUsernameFromToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC512(secret.getBytes())).build();
        DecodedJWT jwt = verifier.verify(token);
        System.out.println("fromUtil :" +jwt.getSubject());
        return jwt.getSubject();
    }

    public boolean validateToken(String token, String username) {
        String tokenUsername = getUsernameFromToken(token);

        return tokenUsername.equals(username) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC512(secret.getBytes())).build();
        DecodedJWT jwt = verifier.verify(token);
        Date expiration = jwt.getExpiresAt();
        return expiration.before(new Date());
    }
}
