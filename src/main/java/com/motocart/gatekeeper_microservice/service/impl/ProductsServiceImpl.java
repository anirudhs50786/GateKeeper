package com.motocart.gatekeeper_microservice.service.impl;

import com.motocart.gatekeeper_microservice.dto.ProductDTO;
import com.motocart.gatekeeper_microservice.integration.ProductsServiceClient;
import com.motocart.gatekeeper_microservice.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    private ProductsServiceClient productsServiceClient;

    @Override
    public String createProduct(ProductDTO productDTO) {
        return productsServiceClient.createProduct(productDTO);
    }

    @Override
    public String updateProduct(ProductDTO productDTO) {
        return productsServiceClient.updateProduct(productDTO);
    }
}
