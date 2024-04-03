package com.practice.toyproject.Filter;

import com.practice.toyproject.Excpetion.BusinessExceptionHandler;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

public class JwtAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // 토큰 필요하지 않은 api url 설정
        List<String> list = List.of(
                "/api/v1/users/login"
        );

        // 토큰 필요 없는 경우 로직
        if(list.contains(request.getRequestURI())){
            filterChain.doFilter(request, response);
        }

        // Client에서 API 요청시 Header에 'Authorization' 이름으로 값이 들어오는지 확인
        String header = request.getHeader("Authorization");

        // header 값이 있는 경우
        if(header != null && !header.equalsIgnoreCase("")){
            // Header 내에 토큰을 추출합니다.
            // 토큰 유효성 확인

            // 다음 filter로 넘긴다. 없으면 Servlet으로 넘긴다.
            filterChain.doFilter(request,response);

        }else{
            throw new BusinessExceptionHandler("token is null", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}