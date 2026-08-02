package com.motocart.gatekeeper_microservice.product.api;

import com.motocart.library.common.dto.CategoriesDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoriesResource {

    ResponseEntity<CategoriesDTO> createCategory(CategoriesDTO categoriesDTO);

    ResponseEntity<CategoriesDTO> updateCategory(CategoriesDTO categoriesDTO);

    ResponseEntity<String> deleteCategory(int categoryId);

    ResponseEntity<List<CategoriesDTO>> getCategories();

    ResponseEntity<CategoriesDTO> getCategory(int categoryId);
}
