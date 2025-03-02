package com.motocart.gatekeeper_microservice.api.rest.impl;

import com.motocart.gatekeeper_microservice.api.rest.ProductsResource;
import com.motocart.gatekeeper_microservice.dto.ProductsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/products")
@Slf4j
public class ProductsResourceImpl implements ProductsResource {

    @PostMapping(produces = "application/json")
    @Override
    public ProductsDTO createProduct(@RequestBody ProductsDTO product) {
        return null;
    }

    @PutMapping(produces = "application/json")
    @Override
    public ProductsDTO updateProduct(@RequestBody ProductsDTO product) {
        return null;
    }
}
