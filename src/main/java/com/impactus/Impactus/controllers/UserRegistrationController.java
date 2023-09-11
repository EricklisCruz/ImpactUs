package com.impactus.Impactus.controllers;

import com.impactus.Impactus.domain.user.Credentials;
import com.impactus.Impactus.dto.CredentialDTO;
import com.impactus.Impactus.services.UserRegistration;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/user")
public class UserRegistrationController {

    private final UserRegistration userRegistration;

    @PostMapping("/registration")
    public ResponseEntity<CredentialDTO> insertCredentials(@RequestBody @Valid Credentials credentials, UriComponentsBuilder uri) {
        credentials = userRegistration.insertCredentials(credentials);
        URI uriComp = uri.path("/{id}").buildAndExpand(credentials.getId()).toUri();
        return ResponseEntity.created(uriComp).body(new CredentialDTO(credentials));
    }

}
