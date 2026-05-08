package com.motocart.gatekeeper_microservice.auth.integration;

import com.motocart.library.common.dto.request.SignInRequestDTO;
import com.motocart.library.common.dto.request.SignUpRequestDTO;
import com.motocart.library.common.dto.response.AuthenticationResponseDTO;
import com.motocart.library.common.dto.response.SignUpResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "ciaas-server", path = "/closedcart/auth")
public interface AuthServiceClient {
    @PostMapping("/register")
    SignUpResponseDTO registerUser(@RequestBody SignUpRequestDTO registrationDTO);

    @PostMapping("/login")
    AuthenticationResponseDTO loginUser(@RequestBody SignInRequestDTO signInRequestDTO);

    @PostMapping("/refresh")
    AuthenticationResponseDTO refreshToken(@RequestHeader("Refresh-Token") String refreshToken);
}
