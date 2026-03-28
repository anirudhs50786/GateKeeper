package com.motocart.gatekeeper_microservice.auth.api.impl;

import com.motocart.gatekeeper_microservice.auth.api.UserAuthResource;
import com.motocart.gatekeeper_microservice.auth.service.UserAuthService;
import com.motocart.library.common.dto.request.SignInRequestDTO;
import com.motocart.library.common.dto.request.SignUpRequestDTO;
import com.motocart.library.common.dto.response.AuthenticationResponseDTO;
import com.motocart.library.common.dto.response.SignUpResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/auth")
@Tag(name = "Authentication", description = "Operations related to user authentication")
public class UserAuthResourceImpl implements UserAuthResource {

    private final UserAuthService userAuthService;

    public UserAuthResourceImpl(UserAuthService userAuthService) {
        this.userAuthService = userAuthService;
    }

    @PostMapping("/register")
    @Operation(description = "Registers a new user")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "User registered successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid registration data"),
            @ApiResponse(responseCode = "500", description = "Registration failed")
    })
    public ResponseEntity<SignUpResponseDTO> registerUser(@Valid @RequestBody SignUpRequestDTO registrationDTO) {
        return ResponseEntity.ok(userAuthService.registerUser(registrationDTO));
    }

    @PostMapping("/login")
    @Operation(description = "Authenticates a user and returns access and refresh tokens")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Login successful"),
            @ApiResponse(responseCode = "401", description = "Invalid credentials"),
            @ApiResponse(responseCode = "500", description = "Login failed")
    })
    public ResponseEntity<AuthenticationResponseDTO> loginUser(@Valid @RequestBody SignInRequestDTO signInRequestDTO) {
        return ResponseEntity.ok(userAuthService.loginUser(signInRequestDTO));
    }

    @PostMapping("/refresh")
    @Operation(description = "Issues a new access token using a valid refresh token")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Token refreshed successfully"),
            @ApiResponse(responseCode = "401", description = "Invalid or expired refresh token"),
            @ApiResponse(responseCode = "500", description = "Token refresh failed")
    })
    public ResponseEntity<AuthenticationResponseDTO> refreshToken(@RequestHeader("Refresh-Token") String refreshToken) {
        return ResponseEntity.ok(userAuthService.refreshToken(refreshToken));
    }
}
