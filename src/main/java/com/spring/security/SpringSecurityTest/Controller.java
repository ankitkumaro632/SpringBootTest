package com.spring.security.SpringSecurityTest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @PreAuthorize("hasRole('NORMAL')")
    @GetMapping("/normal")
    public ResponseEntity<String> normalUser(){
        return ResponseEntity.ok("This API for Normal User");

    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public ResponseEntity<String> adminUser(){
        return ResponseEntity.ok("This API for Admin User");

    }

    @PreAuthorize("hasRole('PUBLIC')")
    @GetMapping("/public")
    public ResponseEntity<String> publicUser(){
        return ResponseEntity.ok("This API for Public User");

    }
}
