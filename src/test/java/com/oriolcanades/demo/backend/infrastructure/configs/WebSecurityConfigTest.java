package com.oriolcanades.demo.backend.infrastructure.configs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class WebSecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void unauthenticatedAccessShouldBeDenied() throws Exception {
        mockMvc.perform(get("/api/v1/default"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void authenticatedAccessShouldReturnOk() throws Exception {
        mockMvc.perform(get("/api/v1/default")
                        .with(httpBasic("test", "test")))
                .andExpect(status().isOk());
    }

    @Test
    void publicEndpointHealthShouldBeAccessible() throws Exception {
        mockMvc.perform(get("/health"))
                .andExpect(status().isOk());
    }

}
