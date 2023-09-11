package com.impactus.Impactus.infra;

import com.impactus.Impactus.domain.user.Credentials;
import com.impactus.Impactus.domain.user.MyUserPrincipal;
import com.impactus.Impactus.infra.security.TokenService;
import com.impactus.Impactus.repositories.UserCredentialsRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final UserCredentialsRepository userCredentialsRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoveryToken(request);
        if (token != null) {
            var login = tokenService.verifyToken(token);
            Credentials user = userCredentialsRepository.findByLogin(login);
            MyUserPrincipal userPrincipal = new MyUserPrincipal(user);

            var authentication = new UsernamePasswordAuthenticationToken(userPrincipal, null,
                    userPrincipal.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(authentication);

        }
        //Acontece quando não possui token
        filterChain.doFilter(request, response);
    }

    private String recoveryToken(HttpServletRequest request) {

        var authHeader = request.getHeader("Authorization");
        if (authHeader == null) return null;
        else return authHeader.replace("Bearer ", "");
    }
}
