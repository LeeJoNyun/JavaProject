package com.example.security.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @PostMapping("/write")
    public ResponseEntity<String> WriteReview(){
        return ResponseEntity.ok().body("정상 처리 되었습니다");
    }

}
