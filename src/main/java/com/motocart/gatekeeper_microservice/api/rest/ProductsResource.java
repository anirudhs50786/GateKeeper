package com.motocart.gatekeeper_microservice.api.rest;

import com.motocart.gatekeeper_microservice.dto.ProductDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductsResource {

    ResponseEntity<String> createProduct(ProductDTO product);

    ResponseEntity<String> updateProduct(ProductDTO product);

    ResponseEntity<String> deleteProduct(int productId);

    ResponseEntity<String> bulkCreateProducts(List<ProductDTO> products);

    ResponseEntity<String> bulkUpdateProduct(List<ProductDTO> products);

    ResponseEntity<ProductDTO> getProduct(int productId);

    ResponseEntity<List<ProductDTO>> getProducts(int categoryId);
}
