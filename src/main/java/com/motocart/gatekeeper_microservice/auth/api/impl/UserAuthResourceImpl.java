package com.motocart.gatekeeper_microservice.auth.api.impl;

import com.motocart.gatekeeper_microservice.auth.api.UserAuthResource;
import com.motocart.gatekeeper_microservice.auth.service.UserAuthService;
import com.motocart.library.common.dto.request.SignUpRequestDTO;
import com.motocart.library.common.dto.response.SignUpResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/auth")
public class UserAuthResourceImpl implements UserAuthResource {

    private final UserAuthService userAuthService;

    public UserAuthResourceImpl(UserAuthService userAuthService) {
        this.userAuthService = userAuthService;
    }

    @PostMapping("/register")
    public SignUpResponseDTO registerUser(@RequestBody SignUpRequestDTO registrationDTO) {
        return userAuthService.registerUser(registrationDTO);
    }
}
