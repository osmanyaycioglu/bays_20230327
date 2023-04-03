package com.training.spring.bays.security;

import java.security.Key;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {

    private final Key key;

    public JWTService() {
        super();
        this.key = Keys.hmacShaKeyFor("keyforhmacfalanfilanosmanyaycioglu".getBytes());
    }

    public String generateToken(final String username,
                                final Collection<? extends GrantedAuthority> roles,
                                final String ip) {
        Instant instant = LocalDateTime.now()
                                       .plusHours(1)
                                       .toInstant(ZoneOffset.UTC);
        Date expDate = Date.from(instant);
        Map<String, Object> claimMap = new HashMap<>();
        claimMap.put("oip",
                     ip);
        if (roles != null) {
            StringBuilder builderLoc = new StringBuilder();
            for (GrantedAuthority grantedAuthorityLoc : roles) {
                builderLoc.append(grantedAuthorityLoc.toString());
                builderLoc.append(",");
            }
            builderLoc.delete(builderLoc.length() - 1,
                              builderLoc.length());
            claimMap.put("role",
                         builderLoc.toString());
        }
        String compactLoc = Jwts.builder()
                                .setSubject(username)
                                .setIssuedAt(new Date())
                                .setExpiration(expDate)
                                .addClaims(claimMap)
                                .signWith(this.key)
                                .compact();
        return compactLoc;
    }

    public Jws<Claims> validate(final String token) {
        JwtParser jwtParserLoc = Jwts.parserBuilder()
                                     .setSigningKey(this.key)
                                     .build();
        Jws<Claims> parseClaimsJwsLoc = null;
        try {
            parseClaimsJwsLoc = jwtParserLoc.parseClaimsJws(token);
        } catch (Exception eLoc) {
            eLoc.printStackTrace();
            return null;
        }
        return parseClaimsJwsLoc;
    }

    public static void main(final String[] args) {
        JWTService jwtServiceLoc = new JWTService();
        String generateTokenLoc = jwtServiceLoc.generateToken("osman",
                                                              null,
                                                              "127.0.0.1");
        System.out.println(generateTokenLoc);

        System.out.println("-----------------");
        Jws<Claims> validateLoc = jwtServiceLoc.validate(generateTokenLoc);
        System.out.println(validateLoc);
    }

}
