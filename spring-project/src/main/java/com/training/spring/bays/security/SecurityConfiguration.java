package com.training.spring.bays.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfiguration {

    @Bean
    public JwtFilter jwtFilter() {
        return new JwtFilter();
    }

    @Bean
    public AuthenticationManager authenticationManager(final HttpSecurity httpSecurityParam,
                                                       final MyUserDetailService detailService,
                                                       final BCryptPasswordEncoder encoderParam) throws Exception {
        AuthenticationManagerBuilder managerBuilderLoc = httpSecurityParam.getSharedObject(AuthenticationManagerBuilder.class);
        return managerBuilderLoc.userDetailsService(detailService)
                                .passwordEncoder(encoderParam)
                                .and()
                                .build();
    }

    @Bean
    public SecurityFilterChain mySecurity(final HttpSecurity httpSecurityParam) throws Exception {
        return httpSecurityParam.csrf(AbstractHttpConfigurer::disable)
                                .cors()
                                .disable()
                                .authorizeHttpRequests(a -> a.requestMatchers("/actuator/**",
                                                                              "/security/**")
                                                             .anonymous()
                                                             .requestMatchers(new AntPathRequestMatcher("/api/v1/employee/provision/**"))
                                                             .hasRole("ADMIN")
                                                             .anyRequest()
                                                             .authenticated())
                                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .addFilterBefore(this.jwtFilter(),
                                                 UsernamePasswordAuthenticationFilter.class)
                                .httpBasic()
                                .disable()
                                .build();
    }

    //    @Bean
    //    public SecurityFilterChain myLocalSecurity(HttpSecurity httpSecurity) throws Exception {
    //        return httpSecurity.authorizeRequests()
    //                           .antMatchers("/actuator/**",
    //                                        "/h2-console/**",
    //                                        "/test/**",
    //                                        "/security/**")
    //                           .anonymous()
    //                           .antMatchers("/api/**")
    //                           .hasAnyRole("ADMIN",
    //                                       "USER",
    //                                       "SUPER_ADMIN")
    //                           .antMatchers("/int/**")
    //                           .hasAnyRole("ADMIN",
    //                                       "USER",
    //                                       "SUPER_ADMIN")
    //                           .and()
    //                           .httpBasic()
    //                           .and()
    //                           .csrf()
    //                           .disable()
    //                           .cors()
    //                           .disable()
    //                           .addFilterBefore(jwtRequestFilter(),
    //                                            UsernamePasswordAuthenticationFilter.class)
    //                           .sessionManagement()
    //                           .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    //                           .and()
    //                           .build();
    //
    //    }
}
