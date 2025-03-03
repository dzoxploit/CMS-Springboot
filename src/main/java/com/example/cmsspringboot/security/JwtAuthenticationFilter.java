package com.example.cmsspringboot.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;


public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtAuthenticationFilter(JwtUtil jwtUtil){
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        // TODO Auto-generated method stub

        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer ")){
            token = token.substring(7);
            if (jwtUtil.validateTokenAuth(token)){
                String username = jwtUtil.extractUsernameAuth(token);
                SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(username, null, null));
            }
        }
        chain.doFilter(request, response);
        throw new UnsupportedOperationException("Unimplemented method 'doFilterInternal'");
    }
    
}
