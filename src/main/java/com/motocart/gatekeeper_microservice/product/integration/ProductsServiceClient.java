package com.motocart.gatekeeper_microservice.product.integration;

import com.motocart.library.common.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "products-server", path = "/closedcart/api/products")
public interface ProductsServiceClient {

    @PostMapping
    String createProduct(@RequestBody ProductDTO product);

    @PutMapping
    String updateProduct(@RequestBody ProductDTO product);

    @GetMapping("/{productName}")
    List<ProductDTO> getProductByName(@PathVariable String productName);

//    @GetMapping("/category")
//    List<ProductDTO> getProductByCategory(@RequestBody );

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
