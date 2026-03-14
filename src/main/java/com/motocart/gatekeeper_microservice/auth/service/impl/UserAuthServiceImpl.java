package com.motocart.gatekeeper_microservice.auth.service.impl;

import com.motocart.gatekeeper_microservice.auth.integration.AuthServiceClient;
import com.motocart.gatekeeper_microservice.auth.service.UserAuthService;
import com.motocart.library.common.dto.request.SignInRequestDTO;
import com.motocart.library.common.dto.request.SignUpRequestDTO;
import com.motocart.library.common.dto.response.AuthenticationResponseDTO;
import com.motocart.library.common.dto.response.SignUpResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class UserAuthServiceImpl implements UserAuthService {

    private final AuthServiceClient authServiceClient;

    public UserAuthServiceImpl(AuthServiceClient authServiceClient) {
        this.authServiceClient = authServiceClient;
    }

    public SignUpResponseDTO registerUser(SignUpRequestDTO registrationDTO) {
        return authServiceClient.registerUser(registrationDTO);
    }

    public AuthenticationResponseDTO loginUser(SignInRequestDTO signInRequestDTO) {
        return authServiceClient.loginUser(signInRequestDTO);
    }

    public AuthenticationResponseDTO refreshToken(String refreshToken) {
        return authServiceClient.refreshToken(refreshToken);
    }
}
