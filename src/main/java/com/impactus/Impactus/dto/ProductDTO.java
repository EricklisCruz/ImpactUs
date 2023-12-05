package com.impactus.Impactus.dto;

import com.impactus.Impactus.domain.product.Product;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
public class ProductDTO {

    @NotNull
    private String name;
    @NotNull
    private BigDecimal price;
    @NotNull
    private Integer quantity;
    @NotNull
    private LocalDateTime data;

    public ProductDTO(@Valid Product product) {
        this.name = product.getName();
        this.price = BigDecimal.valueOf(product.getQuantity());
        this.quantity = product.getQuantity();
        this.data = product.getData();
    }
}
