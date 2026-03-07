package com.motocart.gatekeeper_microservice.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDTO implements Serializable {
    private int productId;
    private String productName;
    private String productCode;
    private String firmName;
    private String productDescription;
    private Long productPrice;
    private String imageUrl;
}
