package com.oriolcanades.demo.backend.infrastructure.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/default")
public class DefaultAppController {

    @GetMapping
    public ResponseEntity<String> getDefaultApp() {
        return ResponseEntity.ok("Default response");
    }

}
