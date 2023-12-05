package com.impactus.Impactus.services;

import com.impactus.Impactus.domain.product.Product;
import com.impactus.Impactus.domain.user.Administrator;
import com.impactus.Impactus.domain.user.Credentials;
import com.impactus.Impactus.repositories.AdministratorRepository;
import com.impactus.Impactus.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AdministratorService {

    private final AdministratorRepository administratorRepository;
    private final ProductRepository productRepository;
    private final UserRegistration userRegistration;


    public Product insertProduct(Product product){
        Credentials credentials = userRegistration.getCurrentUser();
        Administrator administrator = administratorRepository.findAdministratorByCredentials(credentials);
        product.setAdministrator(administrator);
        product.setData(LocalDateTime.now());
        return productRepository.save(product);
    }
}
