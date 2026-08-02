package com.motocart.gatekeeper_microservice.auth.api;

import com.motocart.library.common.dto.request.UserProfileRequestDTO;
import com.motocart.library.common.dto.response.UserProfileResponseDTO;
import org.springframework.http.ResponseEntity;

public interface UserProfileResource {

    ResponseEntity<UserProfileResponseDTO> getUserProfile();

    ResponseEntity<UserProfileResponseDTO> createUserProfile(UserProfileRequestDTO userProfileDTO);
}
