package com.impactus.Impactus.domain.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String lastPhone;
    private String cpf;

    public Customer(String name, String surname, int age, String lastPhone, String cpf) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.lastPhone = lastPhone;
        this.cpf = cpf;
    }
}
