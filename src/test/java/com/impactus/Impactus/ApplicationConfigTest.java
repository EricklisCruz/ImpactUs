package com.impactus.Impactus;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.impactus.Impactus.controllers.UserRegistrationController;
import com.impactus.Impactus.domain.Address;
import com.impactus.Impactus.domain.user.Administrator;
import com.impactus.Impactus.domain.user.Credentials;
import com.impactus.Impactus.enums.UserRoles.UserRole;
import com.impactus.Impactus.repositories.AdministratorRepository;
import com.impactus.Impactus.repositories.UserCredentialsRepository;
import com.impactus.Impactus.services.UserRegistration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.clearAllCaches;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles("test")
public class ApplicationConfigTest {

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Mock
    private UserCredentialsRepository userCredentialsRepository;

    @Autowired
    @InjectMocks
    protected UserRegistrationController userRegistrationController;

    @Mock
    protected UserRegistration userRegistration;
    @Mock
    protected AdministratorRepository administratorRepository;


    @BeforeEach
    public void setup() {
        userCredentialsRepository.deleteAll();
        administratorRepository.deleteAll();
    }

    @AfterEach
    public void afterEach() {
        clearAllCaches();
    }

    @WithUserDetails
    public Credentials adminUserCredentials() {
        return new Credentials(
                "admin@gmail.com", "123456", UserRole.ADMIN_ROLE
        );
    }

    public Credentials commonUserCredentials() {
        return new Credentials(
                "common@gmail.com", "123456", UserRole.USER_ROLE
        );
    }

    public Administrator administratorUser() {
        return new Administrator("test", "87999827257", "1111111111111",
                new Address("Rua", "cidade", "state", "1111111", "country"));
    }


}
