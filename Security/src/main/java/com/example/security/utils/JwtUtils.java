package com.example.security.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import java.security.Key;
import java.time.ZonedDateTime;
import java.util.Date;

public class JwtUtils {
    @Value("${jwt:secret}")
    private String secretKey;
    @Value("${jwt:expiredMs}")
    private static Long expiredMs;


    // jwt 생성
    public static String CreateJwt(String userName){
        // Secret key 생성
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        // 클레임 생성
        Claims claims = Jwts.claims();
        claims.put("username", userName);


        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime tokenValidity = now.plusSeconds(expiredMs);
        // jwt 생성
        // JWT 생성
        return Jwts.builder()
                .setClaims(claims) // 클레임 설정
                .setSubject("subject") // 토큰의 주제 설정
                .setIssuedAt(Date.from(now.toInstant())) // 토큰 발급 시간 설정
                .setExpiration(Date.from(tokenValidity.toInstant())) // 토큰 만료 시간 설정
                .signWith(key) // 서명 설정
                .compact(); // 토큰 생성


    }



}
