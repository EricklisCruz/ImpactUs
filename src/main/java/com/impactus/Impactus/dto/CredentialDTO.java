package com.impactus.Impactus.dto;

import com.impactus.Impactus.domain.user.Credentials;
import com.impactus.Impactus.enums.UserRoles.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class CredentialDTO {

    @NotNull
    @Email
    private String login;
    @NotNull
    private UserRole userRole;

    public CredentialDTO(Credentials credentials) {
        this.login = credentials.getLogin();
        this.userRole = credentials.getUserRole();
    }
}
