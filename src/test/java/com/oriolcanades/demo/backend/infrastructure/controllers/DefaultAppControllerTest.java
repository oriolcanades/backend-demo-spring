package com.oriolcanades.demo.backend.infrastructure.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DefaultAppControllerTest {

    @Test
    void getDefaultAppReturnsDefaultResponse() {
        DefaultAppController controller = new DefaultAppController();
        ResponseEntity<String> response = controller.getDefaultApp();
        assertEquals("Default response", response.getBody());
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    void getDefaultAppReturnsStatusOk() {
        DefaultAppController controller = new DefaultAppController();
        ResponseEntity<String> response = controller.getDefaultApp();
        assertEquals(200, response.getStatusCode().value());
    }

}
