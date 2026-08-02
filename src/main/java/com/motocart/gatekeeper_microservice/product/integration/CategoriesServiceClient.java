package com.motocart.gatekeeper_microservice.product.integration;

import com.motocart.library.common.dto.CategoriesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "products-server", path = "/closedcart/categories")
public interface CategoriesServiceClient {

    @PostMapping
    ResponseEntity<CategoriesDTO> createCategory(@RequestBody CategoriesDTO category);

    @PutMapping
    ResponseEntity<CategoriesDTO> updateCategory(@RequestParam CategoriesDTO requestCategoriesDTO);

    @DeleteMapping("/{categoryId}")
    ResponseEntity<String> deleteCategory(@RequestParam int categoryId);

    @GetMapping("/_query")
    ResponseEntity<List<CategoriesDTO>> getCategories();

    @GetMapping("/{categoryId}")
    ResponseEntity<CategoriesDTO> getCategory(@PathVariable int categoryId);
}
