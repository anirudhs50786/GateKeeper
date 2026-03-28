package com.motocart.gatekeeper_microservice.auth.api;

import com.motocart.library.common.dto.request.SignInRequestDTO;
import com.motocart.library.common.dto.request.SignUpRequestDTO;
import com.motocart.library.common.dto.response.AuthenticationResponseDTO;
import com.motocart.library.common.dto.response.SignUpResponseDTO;
import org.springframework.http.ResponseEntity;

public interface UserAuthResource {
    ResponseEntity<SignUpResponseDTO> registerUser(SignUpRequestDTO registrationDTO);
    ResponseEntity<AuthenticationResponseDTO> loginUser(SignInRequestDTO signInRequestDTO);
    ResponseEntity<AuthenticationResponseDTO> refreshToken(String refreshToken);
}
