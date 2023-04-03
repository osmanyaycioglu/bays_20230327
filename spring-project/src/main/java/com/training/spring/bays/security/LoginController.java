package com.training.spring.bays.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/security")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTService            jwtService;

    @GetMapping("/login")
    public ResponseEntity<String> login(@RequestParam("user") final String username,
                                        @RequestParam("pass") final String password,
                                        final HttpServletRequest requestParam) {
        Authentication authenticateLoc = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,
                                                                                                                         password));
        if (authenticateLoc == null) {
            return ResponseEntity.status(401)
                                 .body("Authentication error");
        }
        return ResponseEntity.status(200)
                             .body(this.jwtService.generateToken(username,
                                                                 authenticateLoc.getAuthorities(),
                                                                 requestParam.getRemoteAddr()));
    }

}
