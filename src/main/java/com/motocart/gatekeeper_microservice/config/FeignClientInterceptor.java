package com.motocart.gatekeeper_microservice.config;

import com.motocart.library.security.Principal;
import com.motocart.library.security.SecurityConstants;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class FeignClientInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            Principal principal = (Principal) authentication.getPrincipal();
            String userId = String.valueOf(principal.userId());
            String userName = principal.username();

            String roles = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.joining(","));

            template.header(SecurityConstants.USER_ID_HEADER, userId);
            template.header(SecurityConstants.USER_ROLES_HEADER, roles);
            template.header(SecurityConstants.USERNAME_HEADER, userName);
        }
    }
}
