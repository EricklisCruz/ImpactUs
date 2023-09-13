package com.impactus.Impactus.controllers;

import com.impactus.Impactus.domain.user.Administrator;
import com.impactus.Impactus.domain.user.Credentials;
import com.impactus.Impactus.domain.user.Customer;
import com.impactus.Impactus.dto.AdministratorDTO;
import com.impactus.Impactus.dto.CredentialDTO;
import com.impactus.Impactus.dto.CustomerDTO;
import com.impactus.Impactus.services.UserRegistration;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping("/customer")
    public ResponseEntity<Customer> insertCustomer(@RequestBody @Valid Customer customer, UriComponentsBuilder uri) {
        customer = userRegistration.insertCustomer(customer);
        URI uriComp = uri.path("/{id}").buildAndExpand(customer).toUri();
        return ResponseEntity.created(uriComp).body(customer);
    }

    @PostMapping("/administrator")
    public ResponseEntity<AdministratorDTO> insertAdministrator(@RequestBody @Valid Administrator administrator, UriComponentsBuilder uri) {
        administrator = userRegistration.insertAdministrator(administrator);
        URI uriComp = uri.path("/{id}").buildAndExpand(administrator).toUri();
        return ResponseEntity.created(uriComp).body(new AdministratorDTO(administrator));
    }

    @GetMapping
    public ResponseEntity<Credentials> getUser(){
        Credentials credentials = userRegistration.getCurrentUser();
        return ResponseEntity.ok().body(credentials);
    }



}
