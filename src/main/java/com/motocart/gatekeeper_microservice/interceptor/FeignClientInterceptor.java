package com.motocart.gatekeeper_microservice.interceptor;

import com.motocart.library.common.types.HttpConstants;
import com.motocart.library.security.Principal;
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

            template.header(HttpConstants.USER_ID_HEADER, userId);
            template.header(HttpConstants.USER_ROLES_HEADER, roles);
            template.header(HttpConstants.USERNAME_HEADER, userName);
        }
    }
}
