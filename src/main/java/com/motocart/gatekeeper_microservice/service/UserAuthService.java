package com.motocart.gatekeeper_microservice.service;

import com.motocart.gatekeeper_microservice.dto.RegistrationDTO;
import com.motocart.gatekeeper_microservice.dto.UserDTO;

public interface UserAuthService {
    UserDTO registerUser(RegistrationDTO registrationDTO);
}
