package com.motocart.gatekeeper_microservice.service;

import com.motocart.gatekeeper_microservice.dto.ProductDTO;

public interface ProductsService {

    String createProduct(ProductDTO productDTO);

    String updateProduct(ProductDTO productDTO);
}
