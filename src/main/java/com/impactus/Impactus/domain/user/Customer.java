package com.impactus.Impactus.domain.user;

import com.impactus.Impactus.domain.Address;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Customer implements Serializable {
    @Serial
    private static final long serialVersionUID = -5373447607285760229L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String lastPhone;
    private String cpf;
    @Embedded
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cod_credential")
    private Credentials credentials;

    public Customer(String name, String surname, int age, String lastPhone, String cpf, Address address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.lastPhone = lastPhone;
        this.cpf = cpf;
        this.address = new Address(address.getStreet(), address.getCity(), address.getState(),
                address.getZipCode(), address.getCountry());
    }
}
