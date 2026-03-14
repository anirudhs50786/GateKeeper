package com.motocart.gatekeeper_microservice.auth.filter;

import com.motocart.gatekeeper_microservice.auth.service.JWTValidatorService;
import com.motocart.library.security.Principal;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JWTValidatorService jwtValidatorService;

    public JwtAuthenticationFilter(JWTValidatorService jwtValidatorService) {
        this.jwtValidatorService = jwtValidatorService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String userId = null;
        String username = null;
        List<SimpleGrantedAuthority> roles = null;

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            token = authHeader.substring(7);
            userId = jwtValidatorService.extractUserId(token);
            roles = Arrays.stream(jwtValidatorService.extractRoles(token)
                            .split(","))
                    .map(SimpleGrantedAuthority::new)
                    .toList();
            username = jwtValidatorService.extractUsername(token);
        }

        if (userId != null && !roles.isEmpty() && SecurityContextHolder.getContext().getAuthentication() == null) {
            if (jwtValidatorService.validateToken(token, userId)) {
                Principal principal = new Principal(Integer.parseInt(userId), username);
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(principal, null, roles);
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
