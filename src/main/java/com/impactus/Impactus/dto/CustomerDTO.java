package com.impactus.Impactus.dto;

import com.impactus.Impactus.domain.Address;
import com.impactus.Impactus.domain.user.Customer;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class CustomerDTO {

    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotNull
    private int age;
    @NotNull
    @Pattern(regexp = "^\\d{10,11}")
    private String lastPhone;
    @NotNull
    @Pattern(regexp = "^\\d{9}")
    private String cpf;
    @NotNull
    private Address address;

    public CustomerDTO(Customer customer) {
        this.name = customer.getName();
        this.surname = customer.getSurname();
        this.age = customer.getAge();
        this.lastPhone = customer.getLastPhone();
        this.cpf = customer.getCpf();
        this.address = new Address(customer.getAddress().getStreet(), customer.getAddress().getCity(),
                customer.getAddress().getState(), customer.getAddress().getZipCode(), customer.getAddress().getCountry());
    }
}
