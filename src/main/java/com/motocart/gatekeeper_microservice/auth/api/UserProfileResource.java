package com.motocart.gatekeeper_microservice.auth.api;

import com.motocart.library.common.dto.UserProfileDTO;
import org.springframework.http.ResponseEntity;

public interface UserProfileResource {

    ResponseEntity<UserProfileDTO> getUserProfile();

    ResponseEntity<UserProfileDTO> createUserProfile(UserProfileDTO userProfileDTO);
}
