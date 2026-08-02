package com.motocart.gatekeeper_microservice.auth.integration;

import com.motocart.library.common.dto.request.UserProfileRequestDTO;
import com.motocart.library.common.dto.response.UserProfileResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ciaas-server", path = "/closedcart/profile", contextId = "profileServiceClient")
public interface ProfileServiceClient {

    @GetMapping
    UserProfileResponseDTO getUserProfile();

    @PostMapping
    UserProfileResponseDTO createUserProfile(@RequestBody UserProfileRequestDTO userProfileDTO);

    ;
}
