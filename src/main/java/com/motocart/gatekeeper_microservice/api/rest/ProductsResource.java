package com.motocart.gatekeeper_microservice.api.rest;

import com.motocart.gatekeeper_microservice.dto.ProductsDTO;

public interface ProductsResource {
    ProductsDTO createProduct(ProductsDTO product);

    ProductsDTO updateProduct(ProductsDTO product);

}
