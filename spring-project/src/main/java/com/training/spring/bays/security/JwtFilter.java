package com.training.spring.bays.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JWTService jwtService;

    @Override
    protected void doFilterInternal(final HttpServletRequest requestParam,
                                    final HttpServletResponse responseParam,
                                    final FilterChain filterChainParam) throws ServletException, IOException {

        String headerLoc = requestParam.getHeader("Authorization");
        if (headerLoc != null) {
            if (headerLoc.startsWith("Bearer")) {

                String token = headerLoc.substring(7);
                Jws<Claims> claimsLoc = this.jwtService.validate(token);
                if (claimsLoc != null) {
                    String subjectLoc = claimsLoc.getBody()
                                                 .getSubject();
                    String rolesLoc = (String) claimsLoc.getBody()
                                                        .get("role");
                    if (rolesLoc != null) {
                        List<SimpleGrantedAuthority> grands = new ArrayList<>();
                        String[] splitLoc = rolesLoc.split(",");
                        for (String stringLoc : splitLoc) {
                            SimpleGrantedAuthority grantedAuthorityLoc = new SimpleGrantedAuthority(stringLoc);
                            grands.add(grantedAuthorityLoc);
                        }
                        Authentication authenticateLoc = new UsernamePasswordAuthenticationToken(subjectLoc,
                                                                                                 "",
                                                                                                 grands);
                        SecurityContextHolder.getContext()
                                             .setAuthentication(authenticateLoc);
                    }
                }
            }
        }
        filterChainParam.doFilter(requestParam,
                                  responseParam);
    }

}
