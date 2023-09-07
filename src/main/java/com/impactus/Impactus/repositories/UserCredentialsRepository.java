package com.impactus.Impactus.repositories;

import com.impactus.Impactus.domain.user.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialsRepository extends JpaRepository<Credentials, Long> {

    Credentials findByLogin(String login);
}
