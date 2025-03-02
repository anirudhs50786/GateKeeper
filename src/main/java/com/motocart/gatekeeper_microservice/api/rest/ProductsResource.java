package com.motocart.gatekeeper_microservice.api.rest;

import com.motocart.gatekeeper_microservice.dto.ProductsDTO;
import org.springframework.http.ResponseEntity;

public interface ProductsResource {
    ResponseEntity<String> createProduct(ProductsDTO product);

    ResponseEntity<String> updateProduct(ProductsDTO product);
}
