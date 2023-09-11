package com.impactus.Impactus.controllers;

import com.impactus.Impactus.ApplicationConfigTest;
import com.impactus.Impactus.domain.user.Credentials;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserRegistrationControllerTest extends ApplicationConfigTest {

    private final static String URL_REGISTRATION = "/user/registration";

    @Test
    public void ShouldCreateAnAdminUser() throws Exception {
        when(userRegistration.insertCredentials(any(Credentials.class)))
                .thenReturn(adminUserCredentials());

        ResultActions resultActions = mockMvc.perform(post(URL_REGISTRATION)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(adminUserCredentials())));
        resultActions.andExpect(status().isCreated());
        assertThat(resultActions).isNotNull();
    }

    @Test
    public void ShouldCreateACommonUser() throws Exception {
        when(userRegistration.insertCredentials(any(Credentials.class)))
                .thenReturn(commonUserCredentials());

        ResultActions resultActions = mockMvc.perform(post(URL_REGISTRATION)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(commonUserCredentials())));

        resultActions.andExpect(status().isCreated());
        assertThat(resultActions).isNotNull();
    }

}
