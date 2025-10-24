package com.motocart.gatekeeper_microservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductsDTO implements Serializable {
    private String name;
    private String productCode;
    private String firmName;
    private String description;
    private Long price;
}
