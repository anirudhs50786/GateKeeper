package com.motocart.gatekeeper_microservice.billing.service;

import com.motocart.library.common.dto.request.StripeRequestDTO;
import com.motocart.library.security.AuthHelper;
import org.springframework.stereotype.Service;

@Service
public class BillingService {

    public StripeRequestDTO buildStripeRequestDTO(int orderId) {
        return StripeRequestDTO.builder()
                .userId(String.valueOf(AuthHelper.getAuthUserId()))
                .cancelUrl("")
                .successUrl("")
                .orderId(String.valueOf(orderId))
                .build();
    }
}
