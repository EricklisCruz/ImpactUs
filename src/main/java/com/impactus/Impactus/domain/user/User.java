package com.impactus.Impactus.domain.user;

import com.impactus.Impactus.domain.Address;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
public abstract class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 4764630265947477004L;

    private String name;
    private String lastPhone;

}
