package com.motocart.gatekeeper_microservice.events;

import com.motocart.gatekeeper_microservice.dto.ProductsDTO;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductsEvent {
    private String eventType;
    private String correlationId;
    private ProductsDTO productsDTO;
}
