package com.motocart.gatekeeper_microservice.dto;

import lombok.Data;

@Data
public class ProductsDTO {
    private String name;
    private String productCode;
    private String firmName;
    private String description;
    private Long price;
}
