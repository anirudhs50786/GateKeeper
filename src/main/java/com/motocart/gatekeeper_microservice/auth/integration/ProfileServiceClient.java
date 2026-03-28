package com.motocart.gatekeeper_microservice.auth.integration;

import com.motocart.library.common.dto.UserProfileDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ciaas-server", path = "/closedcart/api/profile", contextId = "profileServiceClient")
public interface ProfileServiceClient {

    @GetMapping
    UserProfileDTO getUserProfile();

    @PostMapping
    UserProfileDTO createUserProfile(@RequestBody UserProfileDTO userProfileDTO);
}
