package com.motocart.gatekeeper_microservice.auth.service.impl;

import com.motocart.gatekeeper_microservice.auth.integration.CIAASServiceClient;
import com.motocart.gatekeeper_microservice.auth.service.UserAuthService;
import com.motocart.library.common.dto.request.SignUpRequestDTO;
import com.motocart.library.common.dto.response.SignUpResponseDTO;
import org.springframework.stereotype.Service;

@Service
public class UserAuthServiceImpl implements UserAuthService {

    private final CIAASServiceClient ciaasServiceClient;

    public UserAuthServiceImpl(CIAASServiceClient ciaasServiceClient) {
        this.ciaasServiceClient = ciaasServiceClient;
    }

    public SignUpResponseDTO registerUser(SignUpRequestDTO registrationDTO) {
        return ciaasServiceClient.registerUser(registrationDTO);
    }
}
