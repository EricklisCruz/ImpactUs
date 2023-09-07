package com.impactus.Impactus.infra;

import com.impactus.Impactus.infra.security.TokenService;
import com.impactus.Impactus.repositories.UserCredentialsRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final UserCredentialsRepository userCredentialsRepository;

    public SecurityFilter(TokenService tokenService, UserCredentialsRepository userCredentialsRepository) {
        this.tokenService = tokenService;
        this.userCredentialsRepository = userCredentialsRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

    }
}
