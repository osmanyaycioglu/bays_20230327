package com.training.spring.bays.security;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("/*")
public class MyFilter implements Filter {

    @Override
    public void doFilter(final ServletRequest requestParam,
                         final ServletResponse responseParam,
                         final FilterChain chainParam) throws IOException, ServletException {
        System.out.println("********------------- Fiter çalıştı");
        chainParam.doFilter(requestParam,
                            responseParam);
    }

}
