package com.motocart.gatekeeper_microservice.api.rest;

import com.motocart.gatekeeper_microservice.dto.ProductsDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductsResource {

    ResponseEntity<String> createProduct(ProductsDTO product);

    ResponseEntity<String> updateProduct(ProductsDTO product);

    ResponseEntity<String> bulkCreateProducts(@RequestBody List<ProductsDTO> products);

    ResponseEntity<String> bulkUpdateProduct(@RequestBody ProductsDTO product);

    ResponseEntity<String> deleteProduct(@RequestParam int productId);
}
