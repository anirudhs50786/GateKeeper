package com.motocart.gatekeeper_microservice.auth.integration;

import com.motocart.library.common.dto.request.SignUpRequestDTO;
import com.motocart.library.common.dto.response.SignUpResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ciaas-server", path = "/closedcart/api/auth")
public interface CIAASServiceClient {
    @PostMapping("/register")
    SignUpResponseDTO registerUser(@RequestBody SignUpRequestDTO registrationDTO);
}
