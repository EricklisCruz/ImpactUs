package com.impactus.Impactus.controllers;

import com.impactus.Impactus.domain.user.MyUserPrincipal;
import com.impactus.Impactus.dto.AuthenticationDTO;
import com.impactus.Impactus.dto.LoginResponseDTO;
import com.impactus.Impactus.infra.security.TokenService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @Operation(summary = "This method is used to get login")
    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(data.getLogin(),
                data.getPassword());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        var token = tokenService.generateToken((MyUserPrincipal) authentication.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
