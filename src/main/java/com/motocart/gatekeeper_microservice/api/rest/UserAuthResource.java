package com.motocart.gatekeeper_microservice.api.rest;

import com.motocart.gatekeeper_microservice.dto.RegistrationDTO;
import com.motocart.gatekeeper_microservice.dto.UserDTO;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserAuthResource {
    UserDTO registerUser(@RequestBody RegistrationDTO registrationDTO);
}
