package com.motocart.gatekeeper_microservice.service;

import com.motocart.gatekeeper_microservice.dto.ProductDTO;

import java.util.List;

public interface ProductsService {

    String createProduct(ProductDTO productDTO);

    String updateProduct(ProductDTO productDTO);

    List<ProductDTO> getProductByName(String productName);
}
