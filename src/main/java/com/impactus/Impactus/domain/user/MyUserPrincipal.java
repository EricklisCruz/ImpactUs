package com.impactus.Impactus.domain.user;

import com.impactus.Impactus.enums.UserRoles.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class MyUserPrincipal implements UserDetails, Serializable {

    @Serial
    private static final long serialVersionUID = -5240971341812921584L;
    private final Credentials credentials;

    public MyUserPrincipal(Credentials credentials) {
        this.credentials = credentials;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(credentials.getUserRole() == UserRole.ADMIN_ROLE) return List.of(new SimpleGrantedAuthority("ADMIN_ROLE"),
                new SimpleGrantedAuthority("USER_ROLE"));
        else return List.of(new SimpleGrantedAuthority("USER_ROLE"));
    }

    @Override
    public String getPassword() {
        return credentials.getPassword();
    }

    @Override
    public String getUsername() {
        return credentials.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
