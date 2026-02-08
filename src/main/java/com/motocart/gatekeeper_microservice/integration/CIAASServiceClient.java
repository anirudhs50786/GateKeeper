package com.motocart.gatekeeper_microservice.integration;

import com.motocart.gatekeeper_microservice.dto.RegistrationDTO;
import com.motocart.gatekeeper_microservice.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ciaas-server")
public interface CIAASServiceClient {
    @PostMapping("/closedcart/api/auth/register")
    UserDTO registerUser(@RequestBody RegistrationDTO registrationDTO);
}
