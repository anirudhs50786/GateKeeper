package com.motocart.gatekeeper_microservice.auth.api.impl;

import com.motocart.gatekeeper_microservice.auth.api.UserAuthResource;
import com.motocart.gatekeeper_microservice.auth.service.UserAuthService;
import com.motocart.library.common.dto.request.SignInRequestDTO;
import com.motocart.library.common.dto.request.SignUpRequestDTO;
import com.motocart.library.common.dto.response.AuthenticationResponseDTO;
import com.motocart.library.common.dto.response.SignUpResponseDTO;
import org.springframework.web.bind.annotation.*;


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

    @PostMapping("/login")
    public AuthenticationResponseDTO loginUser(@RequestBody SignInRequestDTO signInRequestDTO) {
        return userAuthService.loginUser(signInRequestDTO);
    }

    @PostMapping("/refresh")
    public AuthenticationResponseDTO refreshToken(@RequestHeader("Refresh-Token") String refreshToken) {
        return userAuthService.refreshToken(refreshToken);
    }
}
