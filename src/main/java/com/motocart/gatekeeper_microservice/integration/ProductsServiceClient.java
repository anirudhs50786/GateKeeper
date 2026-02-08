package com.motocart.gatekeeper_microservice.integration;

import com.motocart.gatekeeper_microservice.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "products-server")
public interface ProductsServiceClient {

    @PostMapping("/closedcart/api/products")
    String createProduct(@RequestBody ProductDTO product);

    @PutMapping("/closedcart/api/products")
    String updateProduct(@RequestBody ProductDTO product);

//    String createCategory(String categoryName);
//
//    String updateCategory(int categoryId, String categoryName);
//
//    String deleteCategory(int categoryId);
//
//    List<String> getCategories();
//
//    String getCategory(int categoryId);

}
