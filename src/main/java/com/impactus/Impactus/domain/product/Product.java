package com.impactus.Impactus.domain.product;

import com.impactus.Impactus.domain.user.Administrator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = 9064044015550722190L;
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private Integer quantity;
    private String description;
    @Column(nullable = false)
    private LocalDateTime data;
    @ManyToOne
    @JoinColumn(name = "cod_admistrator")
    private Administrator administrator;

    public Product(String name, BigDecimal price, Integer quantity, String description,LocalDateTime data) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.data = data;
    }
}
