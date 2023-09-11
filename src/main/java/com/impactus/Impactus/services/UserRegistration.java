package com.impactus.Impactus.services;

import com.impactus.Impactus.domain.user.Administrator;
import com.impactus.Impactus.domain.user.Credentials;
import com.impactus.Impactus.repositories.UserCredentialsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRegistration {

    private final UserCredentialsRepository userCredentialsRepository;
    private final PasswordEncoder bCryptPasswordEncoder;

    public Credentials insertCredentials(Credentials credentials) {
        credentials.setPassword(bCryptPasswordEncoder.encode(
                credentials.getPassword()));
        return userCredentialsRepository.save(credentials);
    }

}
