package com.impactus.Impactus.dto;

import com.impactus.Impactus.domain.Address;
import com.impactus.Impactus.domain.user.Administrator;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class AdministratorDTO {

    @NotNull
    private String name;
    @NotNull
    private String lastPhone;
    @NotNull
    @Pattern(regexp = "^\\d{14}")
    private String cnpj;
    @NotNull
    private Address address;

    public AdministratorDTO(Administrator administrator) {
        this.name = administrator.getName();
        this.lastPhone = administrator.getLastPhone();
        this.cnpj = administrator.getCnpj();
        this.address = new Address(administrator.getAddress().getStreet(), administrator.getAddress().getCity(),
                administrator.getAddress().getState(), administrator.getAddress().getZipCode(), administrator.getAddress().getCountry());
    }
}
