package com.motocart.gatekeeper_microservice.api.impl;

import com.motocart.gatekeeper_microservice.api.UserAuthResource;
import com.motocart.gatekeeper_microservice.dto.RegistrationDTO;
import com.motocart.gatekeeper_microservice.dto.UserDTO;
import com.motocart.gatekeeper_microservice.service.UserAuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/auth")
public class UserAuthResourceImpl implements UserAuthResource {

    private final UserAuthService userAuthService;

    public UserAuthResourceImpl(UserAuthService userAuthService) {
        this.userAuthService = userAuthService;
    }

    @PostMapping("/register")
    public UserDTO registerUser(@RequestBody RegistrationDTO registrationDTO) {
        return userAuthService.registerUser(registrationDTO);
    }
}
