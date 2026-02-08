package com.motocart.gatekeeper_microservice.service.impl;

import com.motocart.gatekeeper_microservice.dto.RegistrationDTO;
import com.motocart.gatekeeper_microservice.dto.UserDTO;
import com.motocart.gatekeeper_microservice.integration.CIAASServiceClient;
import com.motocart.gatekeeper_microservice.service.UserAuthService;
import org.springframework.stereotype.Service;

@Service
public class UserAuthServiceImpl implements UserAuthService {

    private final CIAASServiceClient ciaasServiceClient;

    public UserAuthServiceImpl(CIAASServiceClient ciaasServiceClient) {
        this.ciaasServiceClient = ciaasServiceClient;
    }

    public UserDTO registerUser(RegistrationDTO registrationDTO) {
        return ciaasServiceClient.registerUser(registrationDTO);
    }
}
