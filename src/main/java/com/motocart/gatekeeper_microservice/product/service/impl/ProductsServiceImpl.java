package com.motocart.gatekeeper_microservice.product.service.impl;

import com.motocart.gatekeeper_microservice.product.integration.ProductsServiceClient;
import com.motocart.gatekeeper_microservice.product.service.ProductsService;
import com.motocart.library.common.dto.ProductDTO;
import com.motocart.library.common.dto.response.APIResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    private final ProductsServiceClient productsServiceClient;

    public ProductsServiceImpl(ProductsServiceClient productsServiceClient) {
        this.productsServiceClient = productsServiceClient;
    }

    @Override
    public APIResponse<ProductDTO> createProduct(ProductDTO productDTO, MultipartFile productImage) {
        return productsServiceClient.createProduct(productDTO, productImage);
    }

    @Override
    public String updateProduct(ProductDTO productDTO) {
        return productsServiceClient.updateProduct(productDTO);
    }

    @Override
    public List<ProductDTO> getProductByName(String productName) {
        return productsServiceClient.getProductByName(productName);
    }

    @Override
    public String deleteProduct(int productId) {
        // TODO: Add Feign client method and implement
        return "Delete product event published";
    }

    @Override
    public String bulkCreateProducts(List<ProductDTO> products) {
        // TODO: Add Feign client method and implement
        return "Bulk Products create request success";
    }

    @Override
    public String bulkUpdateProduct(List<ProductDTO> products) {
        // TODO: Add Feign client method and implement
        return "Update product event published";
    }

    @Override
    public ProductDTO getProduct(int productId) {
        // TODO: Add Feign client method and implement
        return null;
    }

    @Override
    public List<ProductDTO> getProducts(int categoryId) {
        // TODO: Add Feign client method and implement
        return new ArrayList<>();
    }
}
