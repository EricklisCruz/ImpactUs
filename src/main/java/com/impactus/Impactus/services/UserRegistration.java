package com.impactus.Impactus.services;

import com.impactus.Impactus.domain.user.Administrator;
import com.impactus.Impactus.domain.user.Credentials;
import com.impactus.Impactus.domain.user.Customer;
import com.impactus.Impactus.domain.user.MyUserPrincipal;
import com.impactus.Impactus.repositories.AdministratorRepository;
import com.impactus.Impactus.repositories.CustomerRepository;
import com.impactus.Impactus.repositories.UserCredentialsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegistration {

    private final UserCredentialsRepository userCredentialsRepository;
    private final PasswordEncoder bCryptPasswordEncoder;
    private final CustomerRepository customerRepository;
    private final AdministratorRepository administratorRepository;

    public Credentials insertCredentials(Credentials credentials) {
        credentials.setPassword(bCryptPasswordEncoder.encode(
                credentials.getPassword()));
        return userCredentialsRepository.save(credentials);
    }

    public Credentials getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal != null && principal instanceof MyUserPrincipal) {
            Credentials credentials = ((MyUserPrincipal) principal).credentials();
            return credentials;
        }
        return null;

    }

    public Customer insertCustomer(Customer customer) {
        Credentials credentials = getCurrentUser();
        var user = userCredentialsRepository.findById(credentials.getId()).get();
        customer.setCredentials(user);
        return customerRepository.save(customer);

    }

    public Administrator insertAdministrator(Administrator administrator) {
        Credentials credentials = getCurrentUser();
        var user = userCredentialsRepository.findById(credentials.getId()).get();
        administrator.setCredentials(user);
        return administratorRepository.save(administrator);
    }


}
