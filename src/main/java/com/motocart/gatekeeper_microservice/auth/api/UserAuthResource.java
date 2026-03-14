package com.motocart.gatekeeper_microservice.auth.api;

import com.motocart.library.common.dto.request.SignInRequestDTO;
import com.motocart.library.common.dto.request.SignUpRequestDTO;
import com.motocart.library.common.dto.response.AuthenticationResponseDTO;
import com.motocart.library.common.dto.response.SignUpResponseDTO;

public interface UserAuthResource {
    SignUpResponseDTO registerUser(SignUpRequestDTO registrationDTO);
    AuthenticationResponseDTO loginUser(SignInRequestDTO signInRequestDTO);
    AuthenticationResponseDTO refreshToken(String refreshToken);
}
