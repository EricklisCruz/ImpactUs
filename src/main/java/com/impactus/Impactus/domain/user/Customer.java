package com.impactus.Impactus.domain.user;

import com.impactus.Impactus.domain.Address;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
public class Customer extends User implements Serializable {
    @Serial
    private static final long serialVersionUID = -5373447607285760229L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String surname;
    private int age;
    private String cpf;

    public Customer(String surname, int age, String cpf) {
        this.surname = surname;
        this.age = age;
        this.cpf = cpf;
    }
}
