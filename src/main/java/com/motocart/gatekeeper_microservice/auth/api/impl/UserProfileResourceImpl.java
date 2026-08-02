package com.motocart.gatekeeper_microservice.auth.api.impl;

import com.motocart.gatekeeper_microservice.auth.api.UserProfileResource;
import com.motocart.gatekeeper_microservice.auth.integration.ProfileServiceClient;
import com.motocart.library.common.dto.request.UserProfileRequestDTO;
import com.motocart.library.common.dto.response.UserProfileResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/profile")
@Tag(name = "User Profile", description = "Operations related to user profile management")
public class UserProfileResourceImpl implements UserProfileResource {

    private final ProfileServiceClient profileServiceClient;

    public UserProfileResourceImpl(ProfileServiceClient profileServiceClient) {
        this.profileServiceClient = profileServiceClient;
    }

    @GetMapping
    @Operation(description = "Retrieves the profile of the authenticated user")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Profile retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Profile not found"),
            @ApiResponse(responseCode = "500", description = "Failed to retrieve profile")
    })
    public ResponseEntity<UserProfileResponseDTO> getUserProfile() {
        return ResponseEntity.ok(profileServiceClient.getUserProfile());
    }

    @PostMapping
    @Operation(description = "Creates a profile for the authenticated user")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Profile created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid profile data"),
            @ApiResponse(responseCode = "500", description = "Failed to create profile")
    })
    public ResponseEntity<UserProfileResponseDTO> createUserProfile(@Valid @RequestBody UserProfileRequestDTO userProfileDTO) {
        return ResponseEntity.ok(profileServiceClient.createUserProfile(userProfileDTO));
    }
}
