package com.impactus.Impactus.controllers;

import com.impactus.Impactus.domain.product.Product;
import com.impactus.Impactus.dto.ProductDTO;
import com.impactus.Impactus.services.AdministratorService;
import com.impactus.Impactus.services.ProductService;
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
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final AdministratorService administratorService;

    @PostMapping(value = "/product/administrator")
    public ResponseEntity<ProductDTO> insertProduct(@RequestBody @Valid Product product, UriComponentsBuilder uriComponentsBuilder) {
        product = administratorService.insertProduct(product);
        URI uri = uriComponentsBuilder.path("/{id}").buildAndExpand(product.getId()).toUri();
        return ResponseEntity.created(uri).body(new ProductDTO(product));
    }
}
