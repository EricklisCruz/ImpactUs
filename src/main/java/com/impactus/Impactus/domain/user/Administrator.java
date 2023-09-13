package com.impactus.Impactus.domain.user;

import com.impactus.Impactus.domain.Address;
import com.impactus.Impactus.domain.product.Product;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Administrator implements Serializable {
    @Serial
    private static final long serialVersionUID = 9127122647726027896L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String lastPhone;
    @Column(nullable = false)
    private String cnpj;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_credential")
    private Credentials credentials;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "administrator")
    private List<Product> products = new ArrayList<>();

    public Administrator(String name, String lastPhone, String cnpj, Address address) {
        this.name = name;
        this.lastPhone = lastPhone;
        this.cnpj = cnpj;
        this.address = new Address(address.getStreet(), address.getCity(), address.getState(),
                address.getZipCode(), address.getCountry());
    }
}
