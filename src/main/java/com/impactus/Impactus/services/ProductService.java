package com.impactus.Impactus.services;

import com.impactus.Impactus.domain.product.Product;
import com.impactus.Impactus.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }
}
