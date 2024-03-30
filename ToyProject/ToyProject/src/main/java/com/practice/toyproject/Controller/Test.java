package com.practice.toyproject.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test")
public class Test {

    @PostMapping("/test1")
    public ResponseEntity<String> ResponseString(){
        return ResponseEntity.ok().body("access success");
    }
}
