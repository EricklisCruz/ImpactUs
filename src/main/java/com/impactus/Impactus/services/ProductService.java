package com.impactus.Impactus.services;

import com.impactus.Impactus.domain.product.Product;
import com.impactus.Impactus.enums.UserRoles.UserRole;
import com.impactus.Impactus.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final UserRegistration userRegistration;

    public ProductService(ProductRepository productRepository, UserRegistration userRegistration) {
        this.productRepository = productRepository;
        this.userRegistration = userRegistration;
    }

    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    public void deleteProduct(Long id) {
        try {
            boolean product = productRepository.existsById(id) &&
                    userRegistration.getCurrentUser().getUserRole().equals(UserRole.ADMIN_ROLE);
            if (product) {
                productRepository.deleteById(id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Product not found!");
        }
    }

    public Product updateProduct(Long id, Product product) {
        try {
            Product entity = productRepository.getReferenceById(id);
            updateData(entity, product);
            if (userRegistration.getCurrentUser().equals(UserRole.ADMIN_ROLE)) {
                return productRepository.save(entity);
            }
        } catch (Exception e) {
            throw new RuntimeException("Product not found!");
        }
        throw new RuntimeException("You are not an admin user");
    }

    private void updateData(Product entity, Product product) {
        entity.setPrice(product.getPrice());
        entity.setName(product.getName());
        entity.setQuantity(product.getQuantity());
    }
}
