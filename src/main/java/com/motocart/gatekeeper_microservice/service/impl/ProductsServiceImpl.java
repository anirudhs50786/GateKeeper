package com.motocart.gatekeeper_microservice.service.impl;

import com.motocart.gatekeeper_microservice.dto.ProductDTO;
import com.motocart.gatekeeper_microservice.integration.ProductsServiceClient;
import com.motocart.gatekeeper_microservice.service.ProductsService;
import org.springframework.stereotype.Service;

@Service
public class ProductsServiceImpl implements ProductsService {

    private final ProductsServiceClient productsServiceClient;

    public ProductsServiceImpl(ProductsServiceClient productsServiceClient) {
        this.productsServiceClient = productsServiceClient;
    }

    @Override
    public String createProduct(ProductDTO productDTO) {
        return productsServiceClient.createProduct(productDTO);
    }

    @Override
    public String updateProduct(ProductDTO productDTO) {
        return productsServiceClient.updateProduct(productDTO);
    }
}
