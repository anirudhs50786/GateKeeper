package com.motocart.gatekeeper_microservice.auth.service;

import com.motocart.library.common.dto.request.SignUpRequestDTO;
import com.motocart.library.common.dto.response.SignUpResponseDTO;

public interface UserAuthService {
    SignUpResponseDTO registerUser(SignUpRequestDTO registrationDTO);
}
