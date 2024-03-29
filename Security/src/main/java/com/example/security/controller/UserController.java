package com.example.security.controller;

import com.example.security.utils.JwtUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @PostMapping("/login")
    public ResponseEntity<String> Login(){

        String token = JwtUtils.CreateJwt("김테스트");
        return ResponseEntity.ok().body(token);
    }

}
